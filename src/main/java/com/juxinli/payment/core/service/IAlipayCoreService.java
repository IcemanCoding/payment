package com.juxinli.payment.core.service;

import java.util.Map;
import com.juxinli.payment.core.exception.PaymentException;
import com.juxinli.payment.domain.AlipayWebSignVO;

/**
 * Created by ziqing.chen
 * on 2016/11/14.
 */
public interface IAlipayCoreService {

//    JSONObject webPaySign( AlipayWebSignModel _alipayWebSignModel ) throws Exception;

	Map<String, Object> webPaySign( AlipayWebSignVO webSignVo ) throws PaymentException;

	Boolean verifyWebPayCallback( Map<String, Object> inputsMap ) throws PaymentException;
	
	Integer transQuery( String orderCode ) throws PaymentException;

}
