package com.juxinli.payment.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.infogen.core.util.NativePath;

/**
 * 
 * @author larry
 * @email larry.lv.word@gmail.com
 * @version 创建时间 2013-9-30 下午1:57:58
 */

public class Configuration {
	
	private static final Logger LOGGER = Logger.getLogger( Configuration.class
			.getName() );

	public static Charset charset = StandardCharsets.UTF_8;
	public static final TimeZone TIMEZONE = TimeZone.getTimeZone( "GMT+8" );
	public static final Properties CATEGORY = new Properties();
	public static final Properties TABLES = new Properties();
	public static String ip = null;

	private Configuration() {
	}

	// ////////////////////////////////////////////自身配置/////////////////////////////////////////////
	public static void init() {
		try {
			LOGGER.info( "加载参数" );
			loadArgs();
			LOGGER.info( "加载category" );
			loadCategory();// 根据category映射获取报告的地址拼接部分
			LOGGER.info( "加载 category和website配置相应的表名" );
			loadTableName();// 根据category和website配置相应的表名
			LOGGER.info( "logs库初始化" );
//			ToolMongoLogs.init_mongodb_pool();
			LOGGER.info( "PhoneData库初始化" );
//			ToolMongoPhoneData.init_mongodb_pool();

//			InfoGenTools.init_infoGen();

			ip = InetAddress.getLocalHost().getHostAddress();
		} catch ( Exception e ) {
			LOGGER.error( "Configuration init 失败", e );
		}
	}

	private static void loadCategory() throws IOException {
		Path path = NativePath.get( "conf/category.properties" );
		try ( InputStream resourceAsStream = Files.newInputStream( path,
				StandardOpenOption.READ ); ) {
			CATEGORY.load( resourceAsStream );
			PropertyConfigurator.configure( CATEGORY );
		}
	}

	private static void loadTableName() throws IOException {
		Path path = NativePath.get( "conf/table_name.properties" );
		try ( InputStream resourceAsStream = Files.newInputStream( path,
				StandardOpenOption.READ ); ) {
			TABLES.load( resourceAsStream );
			PropertyConfigurator.configure( TABLES );
		}
	}

	public static String mail_smtp_1_host;
	public static String mail_smtp_1_port;
	public static String mail_smtp_1_username;
	public static String mail_smtp_1_password;
	public static String mail_smtp_prefix;

	// 日志入库异常邮件发送
	public static String mail_smtp_error_logger_send_to;
	// 推送失败邮件提醒
	public static String mailSendTo;

	public static String tm_environment;// 中控服务名称
	public static String interfaceEnvironment;
	public static String bussEnvironment; // bussRule mysql服务名称

	public static String reportLogFile;
	public static String reportLogCopyFile;

	// 报告生成成功后，调用接口通知报告系统生成userlvl级别的报告
	public static String report_complete_notice_url;
	public static String collect_url;

	// 4.0 get_report_url
	public static String V4_0_get_report_url = "";
	// 4.1 get_report_url
	public static String V4_1_get_report_url = "";
	// 4.2 get_report_url
	public static String V4_2_get_report_url = "";
	// indpt_get_report_url
	public static String indpt_get_report_url = "";
	// user get_report_url
	public static String userlvl_get_report_url = "";

	// #get_last_report_number
	public static String get_last_report_number = "";

	public static String env = "";
	// #website report url
	public static String application_form = ""; // 申请表单
	public static String category_report_url = ""; // category 数据源报告需要推送的数据的查询地址
	public static String honeyDataUrl = "";// 获取蜜罐数据地址

	// 不同的环境对应不同的topic配置
	public static String infogen_logger_topic_report_status;
	public static String infogen_logger_topic_job_status;
	public static String infogen_auth_once_topic_job_status;

	public static String otherZookeeper;
	public static String kafka_listener_zookeeper;
	public static String switch_send_report_to_credit;

	public static String sms_url;
	public static String phone_numbers;

	// 报告推送超时设置
	public static Integer connectTimeout; // 建立连接超时
	public static Integer connectionRequestTimeout; // 请求连接超时
	public static Integer socketTimeout; // 响应超时

	public static Integer httpsConnectTimeout;
	public static Integer httpsWriteTimeout;
	public static Integer httpsReadTimeout;

	private static void loadArgs() throws IOException {
		Properties args_properties = new Properties();
		try ( InputStream resourceAsStream = Files.newInputStream(
				NativePath.get( "conf/args.properties" ),
				StandardOpenOption.READ );//
		) {
			args_properties.load( resourceAsStream );
			mail_smtp_1_host = args_properties.getProperty( "mail.smtp.1.host" );
			LOGGER.info( "mail_smtp_1_host" + mail_smtp_1_host );
			mail_smtp_1_port = args_properties.getProperty( "mail.smtp.1.port" );
			mail_smtp_1_username = args_properties
					.getProperty( "mail.smtp.1.username" );
			mail_smtp_1_password = args_properties
					.getProperty( "mail.smtp.1.password" );
			mail_smtp_prefix = args_properties.getProperty( "mail.smtp.prefix" );

			mailSendTo = args_properties.getProperty( "mailSendTo" );

			tm_environment = args_properties.getProperty( "tm.environment" );
			interfaceEnvironment = args_properties
					.getProperty( "interface.environment" );
			bussEnvironment = args_properties.getProperty( "buss.environment" );
			// 消息处理日志
			reportLogFile = args_properties.getProperty( "file.report.log" );
			reportLogCopyFile = args_properties
					.getProperty( "file.report.log.copy" );
			// 性能监控的日志
			// logsLog = args_properties.getProperty("file.logs.log");

			// 报告生成成功后通知通知的URL地址
			report_complete_notice_url = args_properties
					.getProperty( "report_complete_notice_url" );
			collect_url = args_properties.getProperty( "collect_url" );
			infogen_logger_topic_report_status = args_properties
					.getProperty( "infogen_logger_topic_report_status" );
			infogen_logger_topic_job_status = args_properties
					.getProperty( "infogen_logger_topic_job_status" );
			infogen_auth_once_topic_job_status = args_properties
					.getProperty( "infogen_auth_once_topic_job_status" );

			// kafka 监听的zookeeper
			kafka_listener_zookeeper = args_properties
					.getProperty( "kafka_listener_zookeeper" );
			otherZookeeper = args_properties.getProperty( "other_zookeeper" );

			switch_send_report_to_credit = args_properties
					.getProperty( "switch_send_report_to_credit" );

			V4_0_get_report_url = args_properties
					.getProperty( "V4_0_get_report_url" );
			V4_1_get_report_url = args_properties
					.getProperty( "V4_1_get_report_url" );
			V4_2_get_report_url = args_properties
					.getProperty( "V4_2_get_report_url" );
			indpt_get_report_url = args_properties
					.getProperty( "indpt_get_report_url" );
			userlvl_get_report_url = args_properties
					.getProperty( "userlvl_get_report_url" );
			get_last_report_number = args_properties
					.getProperty( "get_last_report_number" );

			application_form = args_properties.getProperty( "application_form" );
			category_report_url = args_properties
					.getProperty( "category_report_url" );
			env = args_properties.getProperty( "envConfig" );
			honeyDataUrl = args_properties.getProperty( "honeyDataUrl" );

			sms_url = args_properties.getProperty( "sms_url" );
			phone_numbers = args_properties.getProperty( "phone_numbers" );
			connectTimeout = Integer.parseInt( args_properties
					.getProperty( "connectTimeout" ) );
			connectionRequestTimeout = Integer.parseInt( args_properties
					.getProperty( "connectionRequestTimeout" ) );
			socketTimeout = Integer.parseInt( args_properties
					.getProperty( "socketTimeout" ) );

			httpsConnectTimeout = Integer.parseInt( args_properties
					.getProperty( "httpsConnectTimeout" ) );
			httpsWriteTimeout = Integer.parseInt( args_properties
					.getProperty( "httpsWriteTimeout" ) );
			httpsReadTimeout = Integer.parseInt( args_properties
					.getProperty( "httpsReadTimeout" ) );
		}
	}
}
