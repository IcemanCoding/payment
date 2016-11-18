package com.juxinli.payment.domain;

import com.juxinli.payment.core.component.PaymentObject;

import java.math.BigDecimal;

/**
 * Created by ziqing.chen
 * on 2016/11/14.
 */
public class AlipayWebSignVO extends PaymentObject {

	private static final long serialVersionUID = 4486153866797717275L;
	
	private String orderCode;
    private BigDecimal amount;
    private String subject;
    private String returnUrl;
    private String notifyUrl;
    private Integer signType;
    private String platformId;

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

	public Integer getSignType() {
		return signType;
	}

	public void setSignType( Integer signType ) {
		this.signType = signType;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId( String platformId ) {
		this.platformId = platformId;
	}
}
