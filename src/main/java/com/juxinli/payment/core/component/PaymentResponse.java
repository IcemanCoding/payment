package com.juxinli.payment.core.component;

import com.juxinli.payment.constants.ResponseCodeEnum;

/**
 * Created by ziqing.chen
 * on 2016/11/11.
 */
public class PaymentResponse extends PaymentObject {

	private static final long serialVersionUID = 473928960435136805L;
	
	private String code;
    private String msg;
    private String status;
    private Object data;
    
    public PaymentResponse() {
	}
    
    public PaymentResponse( String code, String msg, String status, Object data ) {
    	this.code = code;
    	this.msg = msg;
    	this.status = status;
    	this.data = data;
	}
    
    public PaymentResponse( String code, String msg, String status ) {
    	this ( code, msg, status, null );
	}
    
    public static PaymentResponse successResponse() {
    	return new PaymentResponse( ResponseCodeEnum.PROCESS_SUCCESS.getCode(), ResponseCodeEnum.PROCESS_SUCCESS.getMsg(), "success" );
    }
    
    public static PaymentResponse successResponse( Object data ) {
    	return new PaymentResponse( ResponseCodeEnum.PROCESS_SUCCESS.getCode(), ResponseCodeEnum.PROCESS_SUCCESS.getMsg(), "success", data );
    }
    
    public static PaymentResponse failResponse( ResponseCodeEnum resposeCodeEnum ) {
    	return new PaymentResponse( resposeCodeEnum.getCode(), resposeCodeEnum.getMsg(), "fail" );
    }

    public String getCode() {
        return code;
    }

    public void setCode( String code ) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg( String msg ) {
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData( Object data ) {
        this.data = data;
    }

}
