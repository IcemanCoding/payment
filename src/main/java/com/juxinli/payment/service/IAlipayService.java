package com.juxinli.payment.service;

import com.juxinli.payment.core.exception.PaymentException;
import com.juxinli.payment.domain.AlipayWebSignVO;

/**
 * Created by ziqing.chen
 * on 2016/11/15.
 */
public interface IAlipayService {

    String getWebPaySign( AlipayWebSignVO webSignVo ) throws PaymentException;

}
