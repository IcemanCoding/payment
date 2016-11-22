package com.juxinli.payment.domain;

import java.math.BigDecimal;

public class PaymentTransDetailEntity {
	
	private String platformId;
	private String orderCode;
	private Integer processStatus;
	private BigDecimal amount;
	
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
	public Integer getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus( Integer processStatus ) {
		this.processStatus = processStatus;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount( BigDecimal amount ) {
		this.amount = amount;
	}

}
