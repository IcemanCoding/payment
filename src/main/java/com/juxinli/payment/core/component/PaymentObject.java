package com.juxinli.payment.core.component;

import java.io.Serializable;
import java.lang.reflect.Field;

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
    
    public String toString(){ 
    	Field[] fields = this.getClass().getDeclaredFields();
    	StringBuffer sb = new StringBuffer();
    	for( int i=0; i<fields.length; i++ ) {
    		sb.append( fields[i] );
    	}
    	return new String( sb );
    }

}
