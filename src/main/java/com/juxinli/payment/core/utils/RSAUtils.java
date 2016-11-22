package com.juxinli.payment.core.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import com.juxinli.payment.constants.AlipayConfigConstants;
import com.juxinli.payment.constants.AlipayConstants;
import com.juxinli.payment.core.exception.PaymentException;
import com.juxinli.payment.core.utils.codec.Base64;

public class RSAUtils {

	public static String rsaSign( String content, String privateKey,
			String charset ) throws PaymentException {
		try {
			PrivateKey priKey = getPrivateKeyFromPKCS8(
					AlipayConstants.SIGN_TYPE_RSA, new ByteArrayInputStream(
							privateKey.getBytes() ) );

			java.security.Signature signature = java.security.Signature
					.getInstance( AlipayConstants.SIGN_ALGORITHMS );

			signature.initSign( priKey );

			if ( StringUtils.isEmpty( charset ) ) {
				signature.update( content.getBytes() );
			} else {
				signature.update( content.getBytes( charset ) );
			}

			byte[] signed = signature.sign();

			return new String( Base64.encodeBase64( signed ) );
		} catch ( InvalidKeySpecException ie ) {
			throw new PaymentException(
					"RSA绉侀挜鏍煎紡涓嶆纭紝璇锋鏌ユ槸鍚︽纭厤缃簡PKCS8鏍煎紡鐨勭閽�", ie );
		} catch ( Exception e ) {
			throw new PaymentException( "RSAcontent = " + content
					+ "; charset = " + charset, e );
		}
	}

	public static PrivateKey getPrivateKeyFromPKCS8( String algorithm,
			InputStream ins ) throws Exception {
		if ( ins == null || StringUtils.isEmpty( algorithm ) ) {
			return null;
		}

		KeyFactory keyFactory = KeyFactory.getInstance( algorithm );

		byte[] encodedKey = StreamUtils.readText( ins ).getBytes();

		encodedKey = Base64.decodeBase64( encodedKey );

		return keyFactory
				.generatePrivate( new PKCS8EncodedKeySpec( encodedKey ) );
	}

	/**
	 * RSA验签名检查
	 * 
	 * @param content
	 *            待签名数据
	 * @param sign
	 *            签名值
	 * @param ali_public_key
	 *            支付宝公钥
	 * @param input_charset
	 *            编码格式
	 * @return 布尔值
	 */
	public static boolean verify( String content, String sign,
			String ali_public_key, String input_charset ) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance( "RSA" );
			byte[] encodedKey = Base64.decode( ali_public_key );
			PublicKey pubKey = keyFactory
					.generatePublic( new X509EncodedKeySpec( encodedKey ) );

			java.security.Signature signature = java.security.Signature
					.getInstance( AlipayConfigConstants.INSTANT_ARRIVAL_SIGN_ALGORITHMS );

			signature.initVerify( pubKey );
			signature.update( content.getBytes( input_charset ) );

			boolean bverify = signature.verify( Base64.decode( sign ) );
			return bverify;

		} catch ( Exception e ) {
			e.printStackTrace();
		}

		return false;
	}

}
