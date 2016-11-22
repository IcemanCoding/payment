package com.juxinli.payment.domain;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.juxinli.payment.core.component.PaymentObject;

public class PaymentTransDetailEntity extends PaymentObject {

	private static final long serialVersionUID = -8384483988916788701L;

	public static final String REDIS_KEY = "com.juxinli.payment.transdetail.";

	private String platformId;
	private String orderCode;
	private Integer processStatus;
	private BigDecimal amount;
	private Date createDate;
	private Date updateDate;

	public PaymentTransDetailEntity() {
	}

	public PaymentTransDetailEntity( byte[] redisKey, byte[] redisValue ) {
		System.out.println( redisKey + "," + redisValue );
		JSONObject jsonVal;
		try {
			jsonVal = JSONObject.parseObject( new String( redisValue,
					"GB2312" ) );
			processStatus = jsonVal.getInteger( "processStatus" );
			amount = jsonVal.getBigDecimal( "amount" );
			createDate = jsonVal.getDate( "createDate" );
			updateDate = jsonVal.getDate( "updateDate" );
			platformId = new String( redisKey,"GB2312" ).split( "\\." )[4];
			orderCode = new String( redisKey,"GB2312" ).split( "\\." )[5];
		} catch ( UnsupportedEncodingException e ) {
			e.printStackTrace();
		}
	}

	public String getRedisKey() {
		return REDIS_KEY + platformId + "." + orderCode;
	}

	public String getRedisValue() {
		JSONObject jsonVal = new JSONObject();
		jsonVal.put( "amount", amount );
		jsonVal.put( "processStatus", processStatus );
		jsonVal.put( "createDate", createDate );
		jsonVal.put( "updateDate", updateDate );
		return jsonVal.toString();
	}

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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate( Date updateDate ) {
		this.updateDate = updateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate( Date createDate ) {
		this.createDate = createDate;
	}

}
