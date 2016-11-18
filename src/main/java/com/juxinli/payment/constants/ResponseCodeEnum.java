package com.juxinli.payment.constants;

/**
 * Created by ziqing.chen
 * on 2016/11/15.
 */
public enum ResponseCodeEnum {

    PROCESS_SUCCESS( "PAY_000000", "操作成功！" ),
    PROCESS_FAIL( "PAY_000001", "操作失败！" ),

    // ֧������ҳ֧��ǩ�����Ϊ��
    ALIPAY_WEB_INPUT_ORDERCODE_NULL( "PAY_010000", "订单号不能为空！" ),
    ALIPAY_WEB_INPUT_NOTIFYURL_NULL( "PAY_010001", "通知地址不能为空！" ),
    ALIPAY_WEB_INPUT_AMOUNT_NULL( "PAY_010002", "订单金额不能为空！" ),
    ALIPAY_WEB_INPUT_SUBJECT_NULL( "PAY_010003", "商品标题不能为空！" )
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
