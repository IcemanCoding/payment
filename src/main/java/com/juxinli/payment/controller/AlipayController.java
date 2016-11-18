package com.juxinli.payment.controller;

import com.juxinli.payment.constants.ResponseCodeEnum;
import com.juxinli.payment.controller.utils.InputsValidUtils;
import com.juxinli.payment.core.component.PaymentBaseController;
import com.juxinli.payment.core.component.PaymentResponse;
import com.juxinli.payment.domain.AlipayWebSignVO;
import com.juxinli.payment.service.IAlipayService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by ziqing.chen on 2016/11/11.
 */
@Controller
@RequestMapping( value = "alipay" )
public class AlipayController extends PaymentBaseController {

	private final static Logger logger = LoggerFactory
			.getLogger( AlipayController.class );

	@Autowired
	private IAlipayService alipayService;

	@RequestMapping( value = "appPaySign", method = RequestMethod.GET )
	public Map<String, Object> appPaySign() {

		return null;

	}

	@RequestMapping( value = "wapPaySign", method = RequestMethod.GET )
	public Map<String, Object> wapPaySign() {

		return null;

	}

	/**
	 * ziqing.chen
	 */
	@RequestMapping( value = "webPaySign", method = RequestMethod.GET )
	@ResponseBody
	public PaymentResponse webPaySign( AlipayWebSignVO webSignVo ) {

		logger.info( "【webPaySign】【Inputs】" + webSignVo.toJsonString() );
		
		PaymentResponse response = new PaymentResponse();
		ResponseCodeEnum inputsCheck = InputsValidUtils.alipayWebInputsValid( webSignVo );
		if ( inputsCheck != null ) {
			response = PaymentResponse.failResponse( inputsCheck );
		} else {
			try {
				String resData = alipayService.getWebPaySign( webSignVo );
				response = PaymentResponse.successResponse( resData );
			} catch ( Exception e ) {
				logger.error( "【webPaySign】【Exception】", e );
			}
		}
		
		logger.info( "【webPaySign】【Outputs】" + response.toJsonObject() );
		
		return response;

	}

	@RequestMapping( value = "transReport", method = RequestMethod.GET )
	public Map<String, Object> transReport() {

		return null;

	}

}
