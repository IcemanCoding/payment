package com.juxinli.payment.constants;

/**
 * Created by ziqing.chen
 * on 2016/11/15.
 */
public enum ResponseCodeEnum {

    SUCCESS( "JU_00000", "�����ɹ�" ),

    // ֧������ҳ֧��ǩ�����Ϊ��
    ALIPAY_WEB_INPUT_ORDERCODE_NULL( "JU_01000", "�����Ų���Ϊ�գ�" ),
    ALIPAY_WEB_INPUT_NOTIFYURL_NULL( "JU_01001", "������ҳ��ַ����Ϊ�գ�" ),
    ALIPAY_WEB_INPUT_AMOUNT_NULL( "JU_01002", "��������Ϊ�գ�" ),
    ALIPAY_WEB_INPUT_SUBJECT_NULL( "JU_01003", "��Ʒ���ⲻ��Ϊ�գ�" )
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
