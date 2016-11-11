package com.noway.mybatis.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping ( "/test" )
public class TestController {
	
	private final static Logger logger = LoggerFactory.getLogger( TestController.class );
	
	@RequestMapping ( value = "/get", method = RequestMethod.POST )
	@ResponseBody
	public Map<String, Object> authenUser( HttpServletRequest request ) {
		
		logger.info( "入参" );
		
		Map<String, Object> resData = new HashMap<String, Object>();
		resData.put( "code", "success" );
		resData.put( "msg", "操作成功" );
		
		logger.info( "出参" );
		
		return resData;
		
	}

}
