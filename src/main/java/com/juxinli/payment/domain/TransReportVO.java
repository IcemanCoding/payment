package com.juxinli.payment.domain;

import com.juxinli.payment.core.component.PaymentObject;

public class TransReportVO extends PaymentObject {

	private static final long serialVersionUID = -6854341617105202183L;
	
	private String platformId;
	private String orderCode;
	
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId( String platformId ) {
		this.platformId = platformId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode( String orderCode ) {
		this.orderCode = orderCode;
	}

}
