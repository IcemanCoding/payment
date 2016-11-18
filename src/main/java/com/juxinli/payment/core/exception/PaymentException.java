package com.juxinli.payment.core.exception;

/**
 * Created by ziqing.chen
 * on 2016/11/17.
 */
public class PaymentException extends Exception {

    private static final long serialVersionUID = - 238091758285157331L;

    private String errCode;
    private String errMsg;

    public PaymentException() {
        super();
    }

    public PaymentException( String message, Throwable cause ) {
        super( message, cause );
    }

    public PaymentException( String message ) {
        super( message );
    }

    public PaymentException( Throwable cause ) {
        super( cause );
    }

    public PaymentException( String errCode, String errMsg ) {
        super( errCode + ":" + errMsg );
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}
