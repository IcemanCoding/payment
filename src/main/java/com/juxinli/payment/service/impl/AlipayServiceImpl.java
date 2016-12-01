package com.juxinli.payment.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.juxinli.payment.constants.AlipayProcessStatusEnum;
import com.juxinli.payment.core.alipay.AlipayCoreRequestUtils;
import com.juxinli.payment.core.component.PaymentHashMap;
import com.juxinli.payment.core.exception.PaymentException;
import com.juxinli.payment.core.service.IAlipayCoreService;
import com.juxinli.payment.core.utils.BeanUtils;
import com.juxinli.payment.core.utils.EnumUtils;
import com.juxinli.payment.dao.PaymentTransDetailDAO;
import com.juxinli.payment.domain.AlipayWebPaySyncVO;
import com.juxinli.payment.domain.AlipayWebSignVO;
import com.juxinli.payment.domain.PaymentTransDetailEntity;
import com.juxinli.payment.domain.TransReportBO;
import com.juxinli.payment.domain.TransReportVO;
import com.juxinli.payment.redis.dao.PaymentTransDetailCache;
import com.juxinli.payment.service.IAlipayService;

/**
 * Created by ziqing.chen on 2016/11/15.
 */
@Service
public class AlipayServiceImpl implements IAlipayService {

	@Autowired
	private IAlipayCoreService alipayCoreService;
	
	@Autowired
	private PaymentTransDetailCache transDtlCache;
	
	@Autowired
	private PaymentTransDetailDAO transDtlDao;

	@Override
	public String getWebPaySign( AlipayWebSignVO webSignVo )
			throws PaymentException {

		PaymentTransDetailEntity paymentTransDtl = 
				transDtlCache.get( webSignVo.getPlatformId() + "." + webSignVo.getOrderCode() );
		if ( paymentTransDtl != null && paymentTransDtl.getProcessStatus() != 3 ) {
			return "PAY_010100";
		}
		
		Map<String, Object> signInfo = alipayCoreService.webPaySign( webSignVo );
		if ( signInfo == null ) {
			return "PAY_010101";
		}
		
		paymentTransDtl = new PaymentTransDetailEntity();
		paymentTransDtl.setAmount( webSignVo.getAmount() );
		paymentTransDtl.setOrderCode( webSignVo.getOrderCode() );
		paymentTransDtl.setPlatformId( webSignVo.getPlatformId() );
		paymentTransDtl.setProcessStatus( AlipayProcessStatusEnum.INIT_STATUS.getProcessStatus() );
		paymentTransDtl.setUpdateDate( new Date() );
		paymentTransDtl.setCreateDate( new Date() );
		transDtlCache.add( paymentTransDtl );
		
		if ( webSignVo.getSignType() != null && webSignVo.getSignType() == 1 ) {
			// return form
			return AlipayCoreRequestUtils.buildRequestForm( signInfo, "GET",
					"支付" );
		} else {
			// return json
			return new JSONObject( signInfo ).toString();
		}

	}

	@Override
	public void webPayCallbackHandle( AlipayWebPaySyncVO callbackVo ) throws PaymentException {
		
		Map<String, Object> inputsMap = new PaymentHashMap<String, Object>();
		String out_trade_no = "";
		String trade_no = "";
		String trade_status = "";
		String platformId = "";
		try {
			inputsMap = BeanUtils.objectToMap( callbackVo );
			out_trade_no = new String( inputsMap.get( "out_trade_no" ).toString().getBytes( "ISO-8859-1" ), "UTF-8" );
			trade_no = new String( inputsMap.get( "trade_no" ).toString().getBytes( "ISO-8859-1" ), "UTF-8" );
			trade_status = new String( inputsMap.get( "trade_status" ).toString().getBytes( "ISO-8859-1" ), "UTF-8" );
			platformId = new String( inputsMap.get( "extra_common_param" ).toString().getBytes( "ISO-8859-1" ), "UTF-8" );
			if ( alipayCoreService.verifyWebPayCallback( inputsMap ) ) {
				// success 
				// get info by platform & orderCode from cache
				PaymentTransDetailEntity paymentTransDtl = 
						transDtlCache.get( PaymentTransDetailEntity.REDIS_KEY + platformId + "." + out_trade_no );
				paymentTransDtl.setProcessStatus( AlipayProcessStatusEnum.SUCCESS_STATUS.getProcessStatus() );
				// insert mysql
				Integer insertCount = transDtlDao.insert( paymentTransDtl );
				if ( insertCount > 0 ) {
					// remove redis
					transDtlCache.update( paymentTransDtl );
				}
			} else {
				// fail
			}
		} catch ( Exception e ) {
			throw new PaymentException( "【webPayCallbackHandle】", e );
		}

	}

	@Override
	public TransReportBO getTransReport( TransReportVO transReportVo ) throws PaymentException {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put( "orderCode", transReportVo.getOrderCode() );
		params.put( "platformId", transReportVo.getPlatformId() );
		
		PaymentTransDetailEntity paymentTransDtl = 
				transDtlCache.get( PaymentTransDetailEntity.REDIS_KEY + transReportVo.getPlatformId() + "." + transReportVo.getOrderCode() );
		if ( paymentTransDtl == null ) {
			paymentTransDtl = transDtlDao.selectByPrimaryKey( params );
		}
		
		TransReportBO reportBo = new TransReportBO();
		if ( paymentTransDtl == null || paymentTransDtl.getProcessStatus() == AlipayProcessStatusEnum.INIT_STATUS.getProcessStatus() ) {
			
			// 支付宝查询流水
			Integer payStatus = alipayCoreService.transQuery( transReportVo.getOrderCode() );
			
			if ( payStatus == null ) {
				return null;
			}
			if ( AlipayProcessStatusEnum.SUCCESS_STATUS.getProcessStatus() == payStatus ) {
				// success
				reportBo.setProcessStatus( AlipayProcessStatusEnum.SUCCESS_STATUS.getProcessStatus() );
				reportBo.setProcessDesc( AlipayProcessStatusEnum.SUCCESS_STATUS.getMsg() );
				paymentTransDtl.setProcessStatus( AlipayProcessStatusEnum.SUCCESS_STATUS.getProcessStatus() );
			} else if ( AlipayProcessStatusEnum.FAIL_STATUS.getProcessStatus() == payStatus ) {
				// fail
				reportBo.setProcessStatus( AlipayProcessStatusEnum.FAIL_STATUS.getProcessStatus() );
				reportBo.setProcessDesc( AlipayProcessStatusEnum.FAIL_STATUS.getMsg() );
				paymentTransDtl.setProcessStatus( AlipayProcessStatusEnum.FAIL_STATUS.getProcessStatus() );
			} else {
				// ing...
				return new TransReportBO( AlipayProcessStatusEnum.INIT_STATUS.getProcessStatus(), AlipayProcessStatusEnum.INIT_STATUS.getMsg(), transReportVo.getOrderCode() );
			}
			
			reportBo.setOrderCode( transReportVo.getOrderCode() );
			
			// insert mysql
			Integer insertCount = transDtlDao.insert( paymentTransDtl );
			if ( insertCount > 0 ) {
				// remove redis
				transDtlCache.update( paymentTransDtl );
			}
			
		} else {
			reportBo.setOrderCode( transReportVo.getOrderCode() );
			reportBo.setProcessDesc( EnumUtils.getNameByType( AlipayProcessStatusEnum.class, paymentTransDtl.getProcessStatus() ) );
			reportBo.setProcessStatus( paymentTransDtl.getProcessStatus() );
		}
		
		return reportBo;
	}

}
