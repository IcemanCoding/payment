package com.juxinli.payment.core.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.infogen.InfoGen;
import com.infogen.configuration.InfoGen_Configuration;
import com.infogen.core.util.NativePath;
import com.infogen.http.InfoGen_Jetty;
import com.infogen.self_description.component.OutParameter;
import com.infogen.tracking.kafka.InfoGen_Logger_Kafka_Producer;

public class InfoGenTools {

	private static final Logger LOGGER = Logger.getLogger( InfoGenTools.class );

	public static final Properties infoGen_properties = new Properties();
	public static InfoGen_Configuration config;
	public static boolean serverFlag = false;

	public static void init_infoGen() throws Exception {

		Properties service_properties = new Properties();
		try ( InputStream resourceAsStream = Files.newInputStream(
				NativePath.get( "conf/infogen.properties" ),
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

		System.setProperty(
				"org.eclipse.jetty.server.Request.maxFormContentSize",
				"1000000000" );
		InfoGen_Jetty.getInstance().start( config.register_node.getHttp_port(),
				"/" );
		InfoGen_Logger_Kafka_Producer.getInstance().start( config );
		Thread.sleep( 2000 );
		LOGGER.info( "初始化InfoGen成功====================" );
	}
}
