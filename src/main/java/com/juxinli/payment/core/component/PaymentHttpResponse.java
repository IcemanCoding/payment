package com.juxinli.payment.core.component;

import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.Header;
import com.juxinli.payment.constants.AlipayConfigConstants;

public class PaymentHttpResponse {

	/**
	 * 返回中的Header信息
	 */
	private Header[] responseHeaders;

	/**
	 * String类型的result
	 */
	private String stringResult;

	/**
	 * btye类型的result
	 */
	private byte[] byteResult;

	public Header[] getResponseHeaders() {
		return responseHeaders;
	}

	public void setResponseHeaders( Header[] responseHeaders ) {
		this.responseHeaders = responseHeaders;
	}

	public byte[] getByteResult() {
		if ( byteResult != null ) {
			return byteResult;
		}
		if ( stringResult != null ) {
			return stringResult.getBytes();
		}
		return null;
	}

	public void setByteResult( byte[] byteResult ) {
		this.byteResult = byteResult;
	}

	public String getStringResult() throws UnsupportedEncodingException {
		if ( stringResult != null ) {
			return stringResult;
		}
		if ( byteResult != null ) {
			return new String( byteResult, AlipayConfigConstants.SINGLE_TRADE_QUERY_INPUT_CHARSET );
		}
		return null;
	}

	public void setStringResult( String stringResult ) {
		this.stringResult = stringResult;
	}

}
