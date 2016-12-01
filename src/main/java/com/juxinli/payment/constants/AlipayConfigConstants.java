package com.juxinli.payment.constants;

/**
 * Created by ziqing.chen
 * on 2016/11/15.
 */
public class AlipayConfigConstants {

    // Instant arrival ��ʱ����
    public static final String INSTANT_ARRIVAL_SERVER_URL       = "https://mapi.alipay.com/gateway.do";
    public static final String INSTANT_ARRIVAL_SERVICE          = "create_direct_pay_by_user";
    public static final String INSTANT_ARRIVAL_PARTNER          = "2088521254347896";
    public static final String INSTANT_ARRIVAL_INPUT_CHARSET    = "utf-8";
    public static final String INSTANT_ARRIVAL_SIGN_TYPE        = "RSA";
    public static final String INSTANT_ARRIVAL_NOTIFY_URL       = "";
    public static final String INSTANT_ARRIVAL_RETURN_URL       = "";
    public static final String INSTANT_ARRIVAL_PAYMENT_TYPE     = "1";
    public static final String INSTANT_ARRIVAL_SELLER_ID        = "2088521254347896";
    public static final String INSTANT_ARRIVAL_PRIVATE_KEY      = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANziSFCSMlCDpWu8M7Ox8NTmgPbTWuSxjn0t84ZNsqcBWAgCLHjjVJvv7d9FVgnrxtJVrf0VuR6m3VA5FtJRSScCcWwMkxZ8BWVZnAHcmPwdEWiHL9kVvhjPyMMaHuXBydgzp4TeGGhZHIxK1auckT7/qKi44tfSNclcD70e4HmjAgMBAAECgYAYG7aK3LoTIZs/fAYkmcpQYmw3BHCKP3ru3MIUqYxTQAlMrngOJbnJX1GWKeovIQXNVT6tPd67orjLFcAQ6oBSRqPGS3vDhrBrGhTUtDE/upP+acy/X9QQDRAg+pSc/Bkxe2S3nTRpZaOgiLQS8EGRNX0Lo9o/Tt0mEUpIGwlC4QJBAP3o/YJYRoESgv4oikWCbluFe0W8MwCFnohmSbaqlL5va3Hm6FjxYSI7k7HHky1MOYSMAwRi25ZkbPUMSzW2CdMCQQDes7QIhxQtoNO8w6SBOPxZzb5OwnNHBgTr79cF/NT6Zkk7pKjn7f6WXQvE4AMFWfEB667e6gXbYqrfUv16K57xAkEApkf6FW2IJqkf3iBghSro6MjetQmOAQ6AhuUt6xGFPb2sCLjmerEBIrEPhUKk8OpVVKd4pluzYKc977DwZCll/wJAeeg/HgfreMq3/XXPQFmUcghZK73v4qod2ZWRzBpJ78Q8RGTvfP5fxamrfprtrGk+r8F3GVlb2WsahGNmlBD60QJAGXsk9EPr8Iu2OfruWXRLixOmJ0qL3tL1ht4eXo+tNrkGIFRfH32QEVaBkysK3k1Hz6qT7yPtb008VTzcVO7+rg==";
    public static final String INSTANT_ARRIVAL_PUBLIC_KEY       = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
    public static final String INSTANT_ARRIVAL_SIGN_ALGORITHMS	= "SHA1WithRSA";
	public static final String INSTANT_ARRIVAL_HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
    
	public static final String SINGLE_TRADE_QUERY_SERVER_URL	= "https://mapi.alipay.com/gateway.do?";
	public static final String SINGLE_TRADE_QUERY_SERVICE		= "single_trade_query";
	public static final String SINGLE_TRADE_QUERY_PARTNER		= "2088521254347896";
	public static final String SINGLE_TRADE_QUERY_INPUT_CHARSET	= "utf-8";
	public static final String SINGLE_TRADE_QUERY_SIGN_TYPE_MD5	= "MD5";
	public static final String SINGLE_TRADE_QUERY_PRIVATE_KEY	= "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANziSFCSMlCDpWu8M7Ox8NTmgPbTWuSxjn0t84ZNsqcBWAgCLHjjVJvv7d9FVgnrxtJVrf0VuR6m3VA5FtJRSScCcWwMkxZ8BWVZnAHcmPwdEWiHL9kVvhjPyMMaHuXBydgzp4TeGGhZHIxK1auckT7/qKi44tfSNclcD70e4HmjAgMBAAECgYAYG7aK3LoTIZs/fAYkmcpQYmw3BHCKP3ru3MIUqYxTQAlMrngOJbnJX1GWKeovIQXNVT6tPd67orjLFcAQ6oBSRqPGS3vDhrBrGhTUtDE/upP+acy/X9QQDRAg+pSc/Bkxe2S3nTRpZaOgiLQS8EGRNX0Lo9o/Tt0mEUpIGwlC4QJBAP3o/YJYRoESgv4oikWCbluFe0W8MwCFnohmSbaqlL5va3Hm6FjxYSI7k7HHky1MOYSMAwRi25ZkbPUMSzW2CdMCQQDes7QIhxQtoNO8w6SBOPxZzb5OwnNHBgTr79cF/NT6Zkk7pKjn7f6WXQvE4AMFWfEB667e6gXbYqrfUv16K57xAkEApkf6FW2IJqkf3iBghSro6MjetQmOAQ6AhuUt6xGFPb2sCLjmerEBIrEPhUKk8OpVVKd4pluzYKc977DwZCll/wJAeeg/HgfreMq3/XXPQFmUcghZK73v4qod2ZWRzBpJ78Q8RGTvfP5fxamrfprtrGk+r8F3GVlb2WsahGNmlBD60QJAGXsk9EPr8Iu2OfruWXRLixOmJ0qL3tL1ht4eXo+tNrkGIFRfH32QEVaBkysK3k1Hz6qT7yPtb008VTzcVO7+rg==";
    
	
//    public static final String WEBPAY_APP_ID            = "";
//    public static final String WEBPAY_METHOD            = "alipay.trade.wap.pay";
//    public static final String WEBPAY_FORMAT            = "JSON";
//    public static final String WEBPAY_SIGN_TYPE         = "RSA";
//    public static final String WEBPAY_VERSION           = "1.0";
//    public static final String WEBPAY_SELLER_ID         = "";
//    public static final String WEBPAY_PRODUCT_CODE      = "QUICK_WAP_PAY";
//    public static final String WEBPAY_CHARSET           = "gbk";
//    public static final String WEBPAY_RETURN_URL      = "";

}
