package com.juxinli.payment.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.juxinli.payment.core.alipay.AlipayCoreRequestUtils;
import com.juxinli.payment.core.exception.PaymentException;
import com.juxinli.payment.core.service.IAlipayCoreService;
import com.juxinli.payment.domain.AlipayWebSignVO;
import com.juxinli.payment.service.IAlipayService;

/**
 * Created by ziqing.chen
 * on 2016/11/15.
 */
@Service
public class AlipayServiceImpl implements IAlipayService {

    @Autowired
    private IAlipayCoreService alipayCoreService;

    @Override
    public String getWebPaySign( AlipayWebSignVO webSignVo ) throws PaymentException {

        Map<String, Object> signInfo = alipayCoreService.webPaySign( webSignVo );
        if ( webSignVo.getSignType() != null && webSignVo.getSignType() == 1 ) {
        	// return form
        	return AlipayCoreRequestUtils.buildRequestForm( signInfo, "GET", "支付" );
        } else {
        	// return json
        	return new JSONObject( signInfo ).toString();
        }

    }

}
