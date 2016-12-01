package com.juxinli.payment.core.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.juxinli.payment.constants.AlipayConfigConstants;
import com.juxinli.payment.constants.AlipayProcessStatusEnum;
import com.juxinli.payment.constants.ResponseCodeEnum;
import com.juxinli.payment.core.alipay.AlipayCoreRequestUtils;
import com.juxinli.payment.core.alipay.AlipayCoreResponseUtils;
import com.juxinli.payment.core.alipay.AlipaySingleTradeQueryRequest;
import com.juxinli.payment.core.alipay.AlipayWebPayRequest;
import com.juxinli.payment.core.alipay.HttpProtocolHandler;
import com.juxinli.payment.core.component.PaymentHttpRequest;
import com.juxinli.payment.core.component.PaymentHttpResponse;
import com.juxinli.payment.core.component.PaymentHttpReusltType;
import com.juxinli.payment.core.exception.PaymentException;
import com.juxinli.payment.core.service.IAlipayCoreService;
import com.juxinli.payment.core.utils.MD5Utils;
import com.juxinli.payment.core.utils.RSAUtils;
import com.juxinli.payment.domain.AlipayWebSignVO;

/**
 * Created by ziqing.chen on 2016/11/14.
 */
@Service
public class AlipayCoreServiceImpl implements IAlipayCoreService {

	@Override
	public Map<String, Object> webPaySign( AlipayWebSignVO webSignVo )
			throws PaymentException {

		AlipayWebPayRequest webPayRequest = AlipayWebPayRequest
				.initWebPayRequest();
		webPayRequest.setReturn_url( webSignVo.getReturnUrl() );
		webPayRequest.setSubject( webSignVo.getSubject() );
		webPayRequest.setTotal_fee( webSignVo.getAmount() );
		webPayRequest.setOut_trade_no( webSignVo.getOrderCode() );
		webPayRequest.setExtra_common_param( webSignVo.getPlatformId() );

		Map<String, Object> requestParams = webPayRequest.toHashMap();
		String preSignStr = AlipayCoreRequestUtils
				.createLinkString( requestParams );
		String sign = RSAUtils.rsaSign( preSignStr,
				webPayRequest.getPrivateKey(),
				webPayRequest.get_input_charset() );
		requestParams.put( "sign", sign );
		requestParams.put( "sign_type", webPayRequest.getSign_type() );
		requestParams.put( "serverUrl", webPayRequest.getServerUrl() );

		return requestParams;

	}

	@Override
	public Boolean verifyWebPayCallback( Map<String, Object> inputsMap )
			throws PaymentException {

		String trade_status = "";
		try {
			trade_status = new String( inputsMap.get( "trade_status" )
					.toString().getBytes( "ISO-8859-1" ), "UTF-8" );
		} catch ( Exception e ) {
			throw new PaymentException( ResponseCodeEnum.PROCESS_FAIL );
		}

		if ( AlipayCoreResponseUtils.verify( inputsMap ) ) {
			if ( trade_status.equals( "TRADE_FINISHED" )
					|| trade_status.equals( "TRADE_SUCCESS" ) ) {
				return true;
			}
		}
		return false;

	}

	public static void main( String[] args ) {
		AlipayCoreServiceImpl impl = new AlipayCoreServiceImpl();
		AlipayWebSignVO vo = new AlipayWebSignVO();
		vo.setAmount( new BigDecimal( "1.01" ) );
		vo.setOrderCode( "test20156489646" );
		vo.setReturnUrl( "www.baidu.com" );
		vo.setSubject( "test商品123" );
		try {
			impl.webPaySign( vo );
		} catch ( PaymentException e ) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer transQuery( String orderCode ) throws PaymentException {

		AlipaySingleTradeQueryRequest _REQUEST = new AlipaySingleTradeQueryRequest(
				orderCode );
		Map<String, Object> requestParams = _REQUEST.toHashMap();
		Map<String, Object> sPara = AlipayCoreRequestUtils
				.paraFilter( requestParams );
		String prestr = AlipayCoreRequestUtils.createLinkString( sPara );
		String _SIGN = "";
		if ( AlipayConfigConstants.SINGLE_TRADE_QUERY_SIGN_TYPE_MD5
				.equals( _REQUEST.getSign_type() ) ) {
			_SIGN = MD5Utils.sign( prestr, _REQUEST.getPrivate_key(),
					_REQUEST.get_input_charset() );
		}
		sPara.put( "sign", _SIGN );
		sPara.put( "sign_type", _REQUEST.getSign_type() );

		HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler
				.getInstance();

		PaymentHttpRequest request = new PaymentHttpRequest(
				PaymentHttpReusltType.BYTES );
		// 设置编码集
		request.setCharset( AlipayConfigConstants.SINGLE_TRADE_QUERY_INPUT_CHARSET );

		request.setParameters( AlipayCoreRequestUtils.generatNameValuePair( sPara ) );
		request.setUrl( AlipayConfigConstants.SINGLE_TRADE_QUERY_SERVER_URL + "_input_charset="
				+ AlipayConfigConstants.SINGLE_TRADE_QUERY_INPUT_CHARSET );

		try {
			PaymentHttpResponse response;
			response = httpProtocolHandler.execute( request,
					"", "" );
			if ( response == null ) {
				return null;
			}
			String strResult = response.getStringResult();
			
			// 解析xml
			if ( strResult.equals( "success" ) ) {
				return AlipayProcessStatusEnum.SUCCESS_STATUS.getProcessStatus();
			} else if ( strResult.equals( "fail" ) ) {
				return AlipayProcessStatusEnum.FAIL_STATUS.getProcessStatus();
			} else {
				return AlipayProcessStatusEnum.INIT_STATUS.getProcessStatus();
			}
		} catch ( IOException e ) {
			e.printStackTrace();
			return null;
		}

	}
}
