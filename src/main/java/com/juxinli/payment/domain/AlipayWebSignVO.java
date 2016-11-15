package com.juxinli.payment.domain;

import java.math.BigDecimal;

/**
 * Created by ziqing.chen
 * on 2016/11/14.
 */
public class AlipayWebSignVO {

    private String orderCode;
    private BigDecimal amount;
    private String subject;
    private String returnUrl;
    private String notifyUrl;

    public void setNotifyUrl( String notifyUrl ) {
        this.notifyUrl = notifyUrl;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode( String orderCode ) {
        this.orderCode = orderCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount( BigDecimal amount ) {
        this.amount = amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject( String subject ) {
        this.subject = subject;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl( String returnUrl ) {
        this.returnUrl = returnUrl;
    }
}
