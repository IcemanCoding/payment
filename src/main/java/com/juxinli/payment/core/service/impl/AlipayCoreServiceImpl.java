package com.juxinli.payment.core.service.impl;

import java.math.BigDecimal;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.juxinli.payment.constants.ResponseCodeEnum;
import com.juxinli.payment.core.alipay.AlipayCoreRequestUtils;
import com.juxinli.payment.core.alipay.AlipayCoreResponseUtils;
import com.juxinli.payment.core.alipay.AlipayWebPayRequest;
import com.juxinli.payment.core.exception.PaymentException;
import com.juxinli.payment.core.service.IAlipayCoreService;
import com.juxinli.payment.core.utils.RSAUtils;
import com.juxinli.payment.domain.AlipayWebSignVO;

/**
 * Created by ziqing.chen on 2016/11/14.
 */
@Service
public class AlipayCoreServiceImpl implements IAlipayCoreService {

	@Override
	public Map<String, Object> webPaySign( AlipayWebSignVO webSignVo ) throws PaymentException {

		AlipayWebPayRequest webPayRequest = AlipayWebPayRequest
				.initWebPayRequest();
		webPayRequest.setReturn_url( webSignVo.getReturnUrl() );
		webPayRequest.setSubject( webSignVo.getSubject() );
		webPayRequest.setTotal_fee( webSignVo.getAmount() );
		webPayRequest.setOut_trade_no( webSignVo.getOrderCode() );

		Map<String, Object> requestParams = webPayRequest.toHashMap();
		String preSignStr = AlipayCoreRequestUtils.createLinkString( requestParams );
		String sign = RSAUtils.rsaSign( preSignStr,
				webPayRequest.getPrivateKey(),
				webPayRequest.get_input_charset() );
		requestParams.put( "sign", sign );
		requestParams.put( "sign_type", webPayRequest.getSign_type() );
		requestParams.put( "serverUrl", webPayRequest.getServerUrl() );
		
		return requestParams;

	}




	@Override
	public Boolean verifyWebPayCallback( Map<String, Object> inputsMap ) throws PaymentException {
		
		String trade_status = "";
		try {
			trade_status = new String( inputsMap.get( "trade_status" ).toString().getBytes( "ISO-8859-1" ), "UTF-8" );
		} catch ( Exception e ) {
			throw new PaymentException( ResponseCodeEnum.PROCESS_FAIL );
		}

		if ( AlipayCoreResponseUtils.verify( inputsMap ) ) {
			if ( trade_status.equals( "TRADE_FINISHED" ) || trade_status.equals( "TRADE_SUCCESS" ) ) {
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
}
