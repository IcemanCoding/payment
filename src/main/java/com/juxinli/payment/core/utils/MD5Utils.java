package com.juxinli.payment.core.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class MD5Utils {

	public static String sign( String text, String key, String input_charset ) {
		text = text + key;
		return MD5( getContentBytes( text, input_charset ) );
	}

	public final static String MD5( byte[] btInput ) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		try {
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance( "MD5" );
			// 使用指定的字节更新摘要
			mdInst.update( btInput );
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for ( int i = 0; i < j; i++ ) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String( str );
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean verify( String text, String sign, String key,
			String input_charset ) {
		text = text + key;
		String mysign = MD5( getContentBytes( text, input_charset ) );
		if ( mysign.equals( sign ) ) {
			return true;
		} else {
			return false;
		}
	}

	private static byte[] getContentBytes( String content, String charset ) {
		if ( charset == null || "".equals( charset ) ) {
			return content.getBytes();
		}
		try {
			return content.getBytes( charset );
		} catch ( UnsupportedEncodingException e ) {
			throw new RuntimeException( "MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:"
					+ charset );
		}
	}

}
