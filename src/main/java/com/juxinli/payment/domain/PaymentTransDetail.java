package com.juxinli.payment.domain;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentTransDetail {
	
	private String platformId;
	private String orderCode;
	private Integer process_status;
	private BigDecimal amount;
	private Date createDate;
	private Date updateDate;
	
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
	public Integer getProcess_status() {
		return process_status;
	}
	public void setProcess_status( Integer process_status ) {
		this.process_status = process_status;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount( BigDecimal amount ) {
		this.amount = amount;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate( Date createDate ) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate( Date updateDate ) {
		this.updateDate = updateDate;
	}

}
