package com.juxinli.payment.domain;

import com.juxinli.payment.core.component.PaymentObject;

public class TransReportBO extends PaymentObject {

	private static final long serialVersionUID = -8858625840785745155L;
	
	private String orderCode;
	private Integer processStatus;
	private String processDesc;
	
	public TransReportBO() {
	}
	
	public TransReportBO( Integer processStatus, String processDesc, String orderCode ) {
		this.orderCode = orderCode;
		this.processDesc = processDesc;
		this.processStatus = processStatus;
	}
	
	public String getProcessDesc() {
		return processDesc;
	}
	public void setProcessDesc( String processDesc ) {
		this.processDesc = processDesc;
	}
	public Integer getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus( Integer processStatus ) {
		this.processStatus = processStatus;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode( String orderCode ) {
		this.orderCode = orderCode;
	}

}
