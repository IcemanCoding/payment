package com.juxinli.payment.core.component;

/**
 * Created by ziqing.chen
 * on 2016/11/11.
 */
public class PaymentResponse extends PaymentHashMap {

    private Integer code;
    private String msg;
    private String status;
    private Object data;


    public Integer getCode() {
        return code;
    }

    public void setCode( Integer code ) {
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
