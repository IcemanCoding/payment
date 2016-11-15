package com.juxinli.payment.constants;

/**
 * Created by ziqing.chen
 * on 2016/11/15.
 */
public enum ResponseCodeEnum {

    SUCCESS( "JU_00000", "操作成功" ),

    // 支付宝网页支付签名入参为空
    ALIPAY_WEB_INPUT_ORDERCODE_NULL( "JU_01000", "订单号不能为空！" ),
    ALIPAY_WEB_INPUT_NOTIFYURL_NULL( "JU_01001", "回跳网页地址不能为空！" ),
    ALIPAY_WEB_INPUT_AMOUNT_NULL( "JU_01002", "订单金额不能为空！" ),
    ALIPAY_WEB_INPUT_SUBJECT_NULL( "JU_01003", "商品标题不能为空！" )
    ;

    private String code;
    private String msg;

    ResponseCodeEnum( String code, String msg ) {
        this.setCode( code );
        this.setMsg( msg );
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
}
