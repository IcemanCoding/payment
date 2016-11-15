package com.juxinli.payment.controller;


import com.juxinli.payment.constants.ResponseCodeEnum;
import com.juxinli.payment.controller.utils.InputsValidUtils;
import com.juxinli.payment.core.component.PaymentBaseController;
import com.juxinli.payment.domain.AlipayWebSignVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Map;

/**
 * Created by ziqing.chen
 * on 2016/11/11.
 */
@Controller
@RequestMapping ( value = "alipay" )
public class AlipayController extends PaymentBaseController {

    @RequestMapping( value = "appPaySign", method = RequestMethod.GET )
    public Map<String, Object> appPaySign() {


        return null;

    }

    @RequestMapping( value = "webPaySign", method = RequestMethod.GET )
    public Map<String, Object> webPaySign( AlipayWebSignVO webSignVo ) {

        ResponseCodeEnum inputsCheck = InputsValidUtils.alipayWebInputsValid( webSignVo );
        if ( inputsCheck != null ) {
            // return error
        }

        return null;

    }

    @RequestMapping( value = "transReport", method = RequestMethod.GET )
    public Map<String, Object> transReport() {


        return null;

    }

}
