package com.juxinli.payment.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.juxinli.payment.constants.ResponseCodeEnum;
import com.juxinli.payment.core.alipay.AlipayCoreRequestUtils;
import com.juxinli.payment.core.alipay.AlipayCoreResponseUtils;
import com.juxinli.payment.core.component.PaymentHashMap;
import com.juxinli.payment.core.exception.PaymentException;
import com.juxinli.payment.core.service.IAlipayCoreService;
import com.juxinli.payment.core.utils.BeanUtils;
import com.juxinli.payment.domain.AlipayWebPaySyncVO;
import com.juxinli.payment.domain.AlipayWebSignVO;
import com.juxinli.payment.service.IAlipayService;

/**
 * Created by ziqing.chen on 2016/11/15.
 */
@Service
public class AlipayServiceImpl implements IAlipayService {

	@Autowired
	private IAlipayCoreService alipayCoreService;

	@Override
	public String getWebPaySign( AlipayWebSignVO webSignVo )
			throws PaymentException {

		Map<String, Object> signInfo = alipayCoreService.webPaySign( webSignVo );
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
	public String webPayCallbackHandle( AlipayWebPaySyncVO callbackVo )
			throws PaymentException {
		
		Map<String, Object> inputsMap = new PaymentHashMap<String, Object>();
		String out_trade_no = "";
		String trade_no = "";
		String trade_status = "";
		try {
			
			inputsMap = BeanUtils.objectToMap( callbackVo );
			out_trade_no = new String( inputsMap.get( "out_trade_no" ).toString().getBytes( "ISO-8859-1" ), "UTF-8" );
			trade_no = new String( inputsMap.get( "trade_no" ).toString().getBytes( "ISO-8859-1" ), "UTF-8" );
			trade_status = new String( inputsMap.get( "trade_status" ).toString().getBytes( "ISO-8859-1" ), "UTF-8" );
			
			if ( alipayCoreService.verifyWebPayCallback( inputsMap ) ) {
				// success 
				// insert mysql
				// remove redis
			} else {
				// fail
				
			}
		} catch ( Exception e ) {
			throw new PaymentException( ResponseCodeEnum.PROCESS_FAIL );
		}


		return null;

	}

}
