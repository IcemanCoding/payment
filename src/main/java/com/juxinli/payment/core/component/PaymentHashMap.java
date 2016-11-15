package com.juxinli.payment.core.component;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ziqing.chen
 * on 2016/11/11.
 */
public class PaymentHashMap extends HashMap<String, Object> implements Serializable {

    @Override
    public String toString() {
        StringBuffer _toStr = new StringBuffer();
        for ( Map.Entry<String, Object> entry : this.entrySet() ) {
            _toStr.append( " Key = " + entry.getKey() + ", Value = " + entry.getValue() );
        }
        return _toStr.toString();
    }

    public JSONObject toJsonObject() {
        return new JSONObject( this );
    }

}
