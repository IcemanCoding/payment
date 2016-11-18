package com.juxinli.payment.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juxinli.payment.core.component.PaymentBaseController;
import com.juxinli.payment.core.component.PaymentResponse;
import com.juxinli.payment.domain.AlipayWebPaySyncVO;
import com.juxinli.payment.service.IAlipayService;

/**
 * Created by ziqing.chen
 * on 2016/11/14.
 */
@Controller
@RequestMapping( value = "callback" )
public class CallbackController extends PaymentBaseController {

	private final static Logger logger = LoggerFactory.getLogger( CallbackController.class );
	
	@Autowired
	private IAlipayService alipayService;
	
	/**
	 * @author chenziqing@juxinli.com
	 * @date 2016年11月18日 下午4:24:36 
	 * @Title: alipayWebPaySync 
	 * @Description: 同步返回接口（支付宝）
	 * @param @return    设定文件 
	 * @return PaymentResponse    返回类型 
	 */
    @RequestMapping( value = "alipayWebPaySync", method = RequestMethod.POST )
    public PaymentResponse alipayWebPaySync( AlipayWebPaySyncVO webPaySyncVo ) {

    	logger.info( "【alipayWebPaySync】【Inputs】" + webPaySyncVo.toJsonString() );
    	
    	PaymentResponse response = new PaymentResponse();
    	
    	try {
    		alipayService.webPayCallbackHandle( webPaySyncVo );
    	} catch ( Exception e ) {
    		logger.error( "【alipayWebPaySync】【Exception】", e );
    	}
    	
    	logger.info( "【alipayWebPaySync】【Outputs】" + response.toJsonObject() );
    	
        return response;

    }

    @RequestMapping( value = "alipayWebPayAsyn", method = RequestMethod.POST )
    public Map<String, Object> alipayWebPayAsyn() {


        return null;

    }

}
