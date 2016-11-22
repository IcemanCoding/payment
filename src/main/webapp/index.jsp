
<%
	/* *
	 *功能：支付宝手机网站支付接口调试入口页面
	 *版本：3.3
	 *日期：2012-08-17
	 *说明：
	 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
	 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>支付宝手机网站支付2.0接口</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
* {
	margin: 0;
	padding: 0;
}

ul, ol {
	list-style: none;
}

body {
	font-family: "Helvetica Neue", Helvetica, Arial, "Lucida Grande",
		sans-serif;
}

.hidden {
	display: none;
}

.new-btn-login-sp {
	padding: 1px;
	display: inline-block;
	width: 75%;
}

.new-btn-login {
	background-color: #02aaf1;
	color: #FFFFFF;
	font-weight: bold;
	border: none;
	width: 100%;
	height: 30px;
	border-radius: 5px;
	font-size: 16px;
}

#main {
	width: 100%;
	margin: 0 auto;
	font-size: 14px;
}

.red-star {
	color: #f00;
	width: 10px;
	display: inline-block;
}

.null-star {
	color: #fff;
}

.content {
	margin-top: 5px;
}

.content dt {
	width: 100px;
	display: inline-block;
	float: left;
	margin-left: 20px;
	color: #666;
	font-size: 13px;
	margin-top: 8px;
}

.content dd {
	margin-left: 120px;
	margin-bottom: 5px;
}

.content dd input {
	width: 85%;
	height: 28px;
	border: 0;
	-webkit-border-radius: 0;
	-webkit-appearance: none;
}

#foot {
	margin-top: 10px;
	position: absolute;
	bottom: 15px;
	width: 100%;
}

.foot-ul {
	width: 100%;
}

.foot-ul li {
	width: 100%;
	text-align: center;
	color: #666;
}

.note-help {
	color: #999999;
	font-size: 12px;
	line-height: 130%;
	margin-top: 5px;
	width: 100%;
	display: block;
}

#btn-dd {
	margin: 20px;
	text-align: center;
}

.foot-ul {
	width: 100%;
}

.one_line {
	display: block;
	height: 1px;
	border: 0;
	border-top: 1px solid #eeeeee;
	width: 100%;
	margin-left: 20px;
}

.am-header {
	display: -webkit-box;
	display: -ms-flexbox;
	display: box;
	width: 100%;
	position: relative;
	padding: 7px 0;
	-webkit-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box;
	background: #1D222D;
	height: 50px;
	text-align: center;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	box-pack: center;
	-webkit-box-align: center;
	-ms-flex-align: center;
	box-align: center;
}

.am-header h1 {
	-webkit-box-flex: 1;
	-ms-flex: 1;
	box-flex: 1;
	line-height: 18px;
	text-align: center;
	font-size: 18px;
	font-weight: 300;
	color: #fff;
}
</style>
</head>
<body text=#000000 bgColor="#ffffff" leftMargin=0 topMargin=4>
	<form id="alipaysubmit" name="alipaysubmit" action="https://mapi.alipay.com/gateway.do?_input_charset=utf-8" method="get">
		<input type="hidden" name="_input_charset" value="utf-8" /> 
		<input type="hidden" name="subject" value="test商品123" /> 
<!-- 		<input type="hidden" name="notify_url" value="" /> -->
		<input type="hidden" name="sign" 
		value="eN9U4z0JGN8ZGtmkCHfqwjksVummkRDMyGRIqeae9sTpiv7ZYtKfGwQPmTt0QQYXWohzfdxB8kYH3uYRvE/XSOobIU0S+HKXjCiwa4PADiLUuWUfO2w/paLg7CWLITrO8Qcsy7oEcxNauE9YZi3Nt7fZaPIeyDQTyX5pOxLWnCk=" />
<!-- 		<input type="hidden" name="body" value="" />  -->
		<input type="hidden" name="payment_type" value="1" /> 
		<input type="hidden" name="out_trade_no" value="test20156489646" /> 
		<input type="hidden" name="partner" value="2088521254347896" /> 
		<input type="hidden" name="service" value="create_direct_pay_by_user" /> 
		<input type="hidden" name="total_fee" value="1.01" /> 
		<input type="hidden" name="return_url" value="www.baidu.com" /> 
		<input type="hidden" name="sign_type" value="RSA" /> 
		<input type="hidden" name="seller_id" value="2088521254347896" /> 
		<input type="submit" value="确认" style="display: none;">
	</form>
	<script>
		document.forms['alipaysubmit'].submit();
	</script>
</body>
</html>