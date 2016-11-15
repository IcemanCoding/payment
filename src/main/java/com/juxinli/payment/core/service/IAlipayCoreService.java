package com.juxinli.payment.core.service;

import com.alibaba.fastjson.JSONObject;
import com.juxinli.payment.domain.AlipayWebSignModel;

/**
 * Created by ziqing.chen
 * on 2016/11/14.
 */
public interface IAlipayCoreService {

    JSONObject webPaySign( AlipayWebSignModel _alipayWebSignModel ) throws Exception;

}
