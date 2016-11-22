package com.juxinli.payment.core.alipay;

import java.math.BigDecimal;
import java.util.Map;

import com.juxinli.payment.constants.AlipayConfigConstants;
import com.juxinli.payment.core.component.PaymentHashMap;
import com.juxinli.payment.core.component.PaymentObject;

/**
 * Created by ziqing.chen on 2016/11/17.
 */
public class AlipayWebPayRequest extends PaymentObject {
	
	private static final long serialVersionUID = -850494000404481478L;
	
	// base params
	private String serverUrl;
	private String service;
	private String partner;
	private String _input_charset;
	private String sign_type;
	private String notify_url;
	private String return_url;
	private String privateKey;
	private String publicKey;

	// biz params
	private String body;
	private String subject;
	private BigDecimal total_fee;
	private String seller_id;
	private String payment_type;
	private String out_trade_no;
	private String extra_common_param;

	AlipayWebPayRequest() {
		super();
	}
	
	AlipayWebPayRequest( String serverUrl, String service, String partner,
			String inputCharset, String signType, String privateKey,
			String publicKey, String sellerId, String paymentType ) {
		this( serverUrl, service, partner, inputCharset, signType, privateKey, publicKey );
		this.seller_id = sellerId;
		this.payment_type = paymentType;
	}
	
	public static AlipayWebPayRequest initWebPayRequest() {
		return new AlipayWebPayRequest(
				AlipayConfigConstants.INSTANT_ARRIVAL_SERVER_URL,
				AlipayConfigConstants.INSTANT_ARRIVAL_SERVICE,
				AlipayConfigConstants.INSTANT_ARRIVAL_PARTNER,
				AlipayConfigConstants.INSTANT_ARRIVAL_INPUT_CHARSET,
				AlipayConfigConstants.INSTANT_ARRIVAL_SIGN_TYPE,
				AlipayConfigConstants.INSTANT_ARRIVAL_PRIVATE_KEY,
				AlipayConfigConstants.INSTANT_ARRIVAL_PUBLIC_KEY,
				AlipayConfigConstants.INSTANT_ARRIVAL_SELLER_ID,
				AlipayConfigConstants.INSTANT_ARRIVAL_PAYMENT_TYPE );
	}

	AlipayWebPayRequest( String serverUrl, String service, String partner,
			String inputCharset, String signType, String privateKey,
			String publicKey ) {
		this( serverUrl, service, partner, inputCharset );
		this.setSign_type( signType );
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}

	AlipayWebPayRequest( String serverUrl, String service, String partner,
			String inputCharset ) {
		this( serverUrl, service, partner );
		this.set_input_charset( inputCharset );
	}

	AlipayWebPayRequest( String serverUrl, String service, String partner ) {
		this( serverUrl, service );
		this.partner = partner;
	}

	AlipayWebPayRequest( String serverUrl, String service ) {
		this( serverUrl );
		this.service = service;
	}

	AlipayWebPayRequest( String serverUrl ) {
		this.serverUrl = serverUrl;
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
		if ( notify_url != null && !"".equals( notify_url ) ) {
			retMap.put( "notify_url", notify_url );
		} 
		if ( return_url != null && !"".equals( return_url ) ) {
			retMap.put( "return_url", return_url );
		} 
		if ( body != null && !"".equals( body ) ) {
			retMap.put( "body", body );
		} 
		if ( subject != null && !"".equals( subject ) ) {
			retMap.put( "subject", subject );
		}
		if ( total_fee != null ) {
			retMap.put( "total_fee", total_fee );
		}
		if ( seller_id != null && !"".equals( seller_id ) ) {
			retMap.put( "seller_id", seller_id );
		}
		if ( payment_type != null && !"".equals( payment_type ) ) {
			retMap.put( "payment_type", payment_type );
		}
		if ( out_trade_no != null && !"".equals( out_trade_no ) ) {
			retMap.put( "out_trade_no", out_trade_no );
		}
		if ( extra_common_param != null && !"".equals( extra_common_param ) ) {
			retMap.put( "extra_common_param", extra_common_param );
		}
		return retMap;
	}

	public void setServerUrl( String serverUrl ) {
		this.serverUrl = serverUrl;
	}

	public String getServerUrl() {
		return serverUrl;
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

	public void setPrivateKey( String privateKey ) {
		this.privateKey = privateKey;
	}

	public void setPublicKey( String publicKey ) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public String get_input_charset() {
		return _input_charset;
	}

	public void set_input_charset( String _input_charset ) {
		this._input_charset = _input_charset;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type( String sign_type ) {
		this.sign_type = sign_type;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url( String notify_url ) {
		this.notify_url = notify_url;
	}

	public String getReturn_url() {
		return return_url;
	}

	public void setReturn_url( String return_url ) {
		this.return_url = return_url;
	}

	public String getBody() {
		return body;
	}

	public void setBody( String body ) {
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject( String subject ) {
		this.subject = subject;
	}

	public BigDecimal getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee( BigDecimal total_fee ) {
		this.total_fee = total_fee;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id( String seller_id ) {
		this.seller_id = seller_id;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type( String payment_type ) {
		this.payment_type = payment_type;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no( String out_trade_no ) {
		this.out_trade_no = out_trade_no;
	}

	public String getExtra_common_param() {
		return extra_common_param;
	}

	public void setExtra_common_param( String extra_common_param ) {
		this.extra_common_param = extra_common_param;
	}

}
