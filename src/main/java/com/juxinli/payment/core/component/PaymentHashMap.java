package com.juxinli.payment.core.component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by ziqing.chen
 * on 2016/11/11.
 */
public class PaymentHashMap<K, V> extends HashMap<K, V> implements Serializable {

	private static final long serialVersionUID = 1282137472478623541L;

	@Override
    public String toString() {
        StringBuffer _toStr = new StringBuffer();
        for ( Map.Entry<K, V> entry : this.entrySet() ) {
            _toStr.append( " Key = " + entry.getKey() + ", Value = " + entry.getValue() );
        }
        return _toStr.toString();
    }

	@SuppressWarnings( "unchecked" )
	public JSONObject toJsonObject() {
        return new JSONObject( ( Map<String, Object> ) this );
    }

}
