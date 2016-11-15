package com.juxinli.payment.controller;

import com.juxinli.payment.core.component.PaymentBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by ziqing.chen
 * on 2016/11/14.
 */
@Controller
@RequestMapping( value = "callback" )
public class CallbackController extends PaymentBaseController {

    @RequestMapping( value = "alipaySync", method = RequestMethod.POST )
    public Map<String, Object> alipaySync() {


        return null;

    }

    @RequestMapping( value = "alipayAsyn", method = RequestMethod.POST )
    public Map<String, Object> alipayAsyn() {


        return null;

    }

}
