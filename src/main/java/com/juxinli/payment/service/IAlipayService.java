package com.juxinli.payment.service;

import com.juxinli.payment.core.exception.PaymentException;
import com.juxinli.payment.domain.AlipayWebPaySyncVO;
import com.juxinli.payment.domain.AlipayWebSignVO;
import com.juxinli.payment.domain.TransReportBO;
import com.juxinli.payment.domain.TransReportVO;

/**
 * Created by ziqing.chen
 * on 2016/11/15.
 */
public interface IAlipayService {

    String getWebPaySign( AlipayWebSignVO webSignVo ) throws PaymentException;
    
    void webPayCallbackHandle( AlipayWebPaySyncVO callbackVo ) throws PaymentException;

    TransReportBO getTransReport( TransReportVO transReportVo ) throws PaymentException;

}
