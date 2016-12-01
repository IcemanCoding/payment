package com.juxinli.payment.core.alipay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;

import com.juxinli.payment.constants.AlipayConfigConstants;
import com.juxinli.payment.core.exception.PaymentException;
import com.juxinli.payment.core.utils.RSAUtils;

public class AlipayCoreRequestUtils {

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, Object> paraFilter( Map<String, Object> sArray ) {

		Map<String, Object> result = new HashMap<String, Object>();
		if ( sArray == null || sArray.size() <= 0 ) {
			return result;
		}
		for ( String key : sArray.keySet() ) {
			String value = sArray.get( key ) + "";
			if ( value == null || value.equals( "" )
					|| key.equalsIgnoreCase( "sign" )
					|| key.equalsIgnoreCase( "sign_type" ) ) {
				continue;
			}
			result.put( key, value );
		}
		return result;

	}

	public static String createLinkString( Map<String, Object> params ) {
		List<String> keys = new ArrayList<String>( params.keySet() );
		Collections.sort( keys );
		String prestr = "";
		for ( int i = 0; i < keys.size(); i++ ) {
			String key = keys.get( i );
			Object value = params.get( key );
			if ( i == keys.size() - 1 ) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		return prestr;
	}

	public static String buildRequestForm( Map<String, Object> sParaTemp,
			String strMethod, String strButtonName ) {

		String gatewayUrl = sParaTemp.get( "serverUrl" ) + "";
		sParaTemp.remove( "serverUrl" );

		// 待请求参数数组
		List<String> keys = new ArrayList<String>( sParaTemp.keySet() );

		StringBuffer sbHtml = new StringBuffer();

		sbHtml.append( "<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\""
				+ gatewayUrl
				+ "_input_charset="
				+ sParaTemp.get( "_input_charset" )
				+ "\" method=\""
				+ strMethod + "\">" );

		for ( int i = 0; i < keys.size(); i++ ) {
			String name = keys.get( i ) + "";
			String value = sParaTemp.get( name ) + "";

			sbHtml.append( "<input type=\"hidden\" name=\"" + name
					+ "\" value=\"" + value + "\"/>" );
		}

		// submit按钮控件请不要含有name属性
		sbHtml.append( "<input type=\"submit\" value=\"" + strButtonName
				+ "\" style=\"display:none;\"></form>" );
		sbHtml.append( "<script>document.forms['alipaysubmit'].submit();</script>" );
		System.out.println( "form : " + sbHtml.toString() );

		return sbHtml.toString();

	}

	public static NameValuePair[] generatNameValuePair(
			Map<String, Object> properties ) {
		NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
		int i = 0;
		for ( Map.Entry<String, Object> entry : properties.entrySet() ) {
			nameValuePair[i++] = new NameValuePair( entry.getKey(),
					( String ) entry.getValue() );
		}

		return nameValuePair;
	}

	public static void main( String[] args ) throws PaymentException {

		String content = "_input_charset=utf-8&notify_url=http://116.226.85.211/create_direct_pay_by_user-JAVA-UTF-8/notify_url.jsp&out_trade_no=test20161117171242&partner=2088521254347896&payment_type=1&return_url=www.baidu.com&seller_id=2088521254347896&service=create_direct_pay_by_user&subject=test商品123&total_fee=0.01";
		String charset = AlipayConfigConstants.INSTANT_ARRIVAL_INPUT_CHARSET;
		String privateKey = AlipayConfigConstants.INSTANT_ARRIVAL_PRIVATE_KEY;
		String sign = RSAUtils.rsaSign( content, privateKey, charset );
		System.out.println( sign );

	}

}
