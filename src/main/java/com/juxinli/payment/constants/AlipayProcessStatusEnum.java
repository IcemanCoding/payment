package com.juxinli.payment.constants;

import com.juxinli.payment.core.component.EnumMsg;

public enum AlipayProcessStatusEnum implements EnumMsg {

	INIT_STATUS( 1, "支付中" ), SUCCESS_STATUS( 2, "支付成功" ), FAIL_STATUS( 3,
			"支付失败" );

	private Integer processStatus;
	private String msg;

	AlipayProcessStatusEnum( Integer processStatus, String msg ) {
		this.setProcessStatus( processStatus );
		this.setMsg( msg );
	}

	public Integer getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus( Integer processStatus ) {
		this.processStatus = processStatus;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg( String msg ) {
		this.msg = msg;
	}

	@Override
	public String getName() {
		return this.msg;
	}

	@Override
	public int getType() {
		return this.processStatus;
	}

}
