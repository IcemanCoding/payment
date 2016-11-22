package com.juxinli.payment.core.component;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by ziqing.chen
 * on 2016/11/17.
 */
public class PaymentObject extends Object implements Serializable {

	private static final long serialVersionUID = -6322137983250443955L;

	public Object toJson() {
        return JSON.toJSON( this );
    }

    public JSONObject toJsonObject() {
        return ( JSONObject ) JSONObject.toJSON( this );
    }

    public String toJsonString() {
        return JSON.toJSONString( this );
    }

}
