package com.juxinli.payment.core.alipay;

import java.util.Map;

import com.juxinli.payment.constants.AlipayConfigConstants;
import com.juxinli.payment.core.component.PaymentHashMap;
import com.juxinli.payment.core.component.PaymentObject;

public class AlipaySingleTradeQueryRequest extends PaymentObject {

	private static final long serialVersionUID = -8720655379059301711L;
	
	private String service;
	private String partner;
	private String _input_charset;
	private String out_trade_no;
	private String sign_type;
	private String private_key;
	
	public AlipaySingleTradeQueryRequest() {
	}
	
	public AlipaySingleTradeQueryRequest( String service, String partner, String _input_charset, String out_trade_no,
			String sign_type, String private_key ) {
		this.service = service;
		this.partner = partner;
		this._input_charset = _input_charset;
		this.out_trade_no = out_trade_no;
		this.sign_type = sign_type;
		this.private_key = private_key;
	}
	
	public AlipaySingleTradeQueryRequest( String out_trade_no ) {
		this.service = AlipayConfigConstants.SINGLE_TRADE_QUERY_SERVICE;
		this.partner = AlipayConfigConstants.SINGLE_TRADE_QUERY_PARTNER;
		this._input_charset = AlipayConfigConstants.SINGLE_TRADE_QUERY_INPUT_CHARSET;
		this.sign_type = AlipayConfigConstants.SINGLE_TRADE_QUERY_SIGN_TYPE_MD5;
		this.private_key = AlipayConfigConstants.SINGLE_TRADE_QUERY_PRIVATE_KEY;
		this.out_trade_no = out_trade_no;
	}
	
	public Map<String, Object> toHashMap() {
		Map<String, Object> retMap = new PaymentHashMap<String, Object>();
		if ( service != null && !"".equals( service ) ) {
			retMap.put( "service", service );
		}
		if ( partner != null && !"".equals( partner ) ) {
			retMap.put( "partner", partner );
		}
		if ( _input_charset != null && !"".equals( _input_charset ) ) {
			retMap.put( "_input_charset", _input_charset );
		}
		if ( out_trade_no != null && !"".equals( out_trade_no ) ) {
			retMap.put( "out_trade_no", out_trade_no );
		} 
		return retMap;
	}
	
	public String getService() {
		return service;
	}
	public void setService( String service ) {
		this.service = service;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner( String partner ) {
		this.partner = partner;
	}
	public String get_input_charset() {
		return _input_charset;
	}
	public void set_input_charset( String _input_charset ) {
		this._input_charset = _input_charset;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no( String out_trade_no ) {
		this.out_trade_no = out_trade_no;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPrivate_key() {
		return private_key;
	}

	public void setPrivate_key( String private_key ) {
		this.private_key = private_key;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type( String sign_type ) {
		this.sign_type = sign_type;
	}
	
}
