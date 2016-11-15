package com.juxinli.payment.controller.utils;

import com.juxinli.payment.constants.ResponseCodeEnum;
import com.juxinli.payment.domain.AlipayWebSignVO;

import java.math.BigDecimal;

/**
 * Created by ziqing.chen
 * on 2016/11/15.
 */
public class InputsValidUtils {

    public static ResponseCodeEnum alipayWebInputsValid( AlipayWebSignVO alipayWebSignVo ) {

        if ( alipayWebSignVo.getOrderCode() == null || "".equals( alipayWebSignVo.getOrderCode() ) ) {
            return ResponseCodeEnum.ALIPAY_WEB_INPUT_ORDERCODE_NULL;
        }
        if ( alipayWebSignVo.getNotifyUrl() == null || "".equals( alipayWebSignVo.getNotifyUrl() ) ) {
            return ResponseCodeEnum.ALIPAY_WEB_INPUT_NOTIFYURL_NULL;
        }
        if ( alipayWebSignVo.getAmount() == null || alipayWebSignVo.getAmount().compareTo( BigDecimal.ZERO ) == 0 ) {
            return ResponseCodeEnum.ALIPAY_WEB_INPUT_AMOUNT_NULL;
        }
        if ( alipayWebSignVo.getSubject() == null || "".equals( alipayWebSignVo.getSubject() ) ) {
            return ResponseCodeEnum.ALIPAY_WEB_INPUT_SUBJECT_NULL;
        }
        return null;

    }

}
