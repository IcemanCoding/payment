package com.juxinli.payment.core.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.infogen.configuration.InfoGen_Configuration;
import com.infogen.core.util.NativePath;
import com.infogen.self_description.component.OutParameter;
import com.infogen.tracking.kafka.InfoGen_Logger_Kafka_Producer;

public class Launcher {
	public static final Logger LOG = Logger
			.getLogger( Launcher.class.getName() );

	public static void main( String[] args ) throws Exception {

		Properties service_properties = new Properties();
		try ( InputStream resourceAsStream = Files
				.newInputStream( NativePath.get( "infogen.properties" ),
						StandardOpenOption.READ );//
				InputStreamReader inputstreamreader = new InputStreamReader(
						resourceAsStream, InfoGen_Configuration.charset ); ) {
			service_properties.load( inputstreamreader );
		}

		InfoGen_Configuration config = InfoGen_Configuration.getInstance()
				.initialization( service_properties );
		config.add_basic_outparameter( new OutParameter( "note", String.class,
				false, "", "错误描述" ) );
		config.add_basic_outparameter( new OutParameter(
				"code",
				Integer.class,
				true,
				"200",
				"错误码<br>200 成功<br>400 参数不正确<br>401 特定参数不符合条件(eg:没有这个用户)<br>404 没有这个方法 (RPC调用)<br>500 错误" ) );

		InfoGen_Logger_Kafka_Producer.getInstance().start( config );

		Configuration.init();
		LOG.info( "Configuration.ip=" + Configuration.ip );
		;
		// 固定wuxiA-54和wuxiB-65机器执行补推报告和邮件提醒。
		/*
		 * if (Configuration.env.equals("www") && Configuration.ip != null) { if
		 * ( Configuration.ip.equals("172.16.1.65")) {
		 * TimerReportRemedial.runMonitorSchedule();
		 * LOG.info(Configuration.ip+"补推程序和邮件提醒已经开启"); } }
		 */
		/*
		 * //jd-254.40和jdtest-59环境固定ip执行定时器 if (Configuration.env.equals("jd")
		 * && Configuration.ip != null) { if
		 * (Configuration.ip.equals("10.255.254.40") ||
		 * Configuration.ip.equals("10.255.253.59")) {
		 * TimerReportRemedial.runMonitorSchedule();
		 * LOG.info(Configuration.ip+"补推程序和邮件提醒已经开启");; }
		 * 
		 * }
		 */
		// MailTip.runMonitorSchedule();
	}
}
