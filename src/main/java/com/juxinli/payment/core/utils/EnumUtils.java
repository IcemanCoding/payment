package com.juxinli.payment.core.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.juxinli.payment.core.component.EnumMsg;


public class EnumUtils {

	public static Integer getTypeByName( Class<?> c, String name ) {
		try {
			EnumMsg[] enumMsgs = ( EnumMsg[] ) c.getMethod( "values" ).invoke(
					null );
			for ( EnumMsg e : enumMsgs ) {
				if ( e.getName().equals( name ) ) {
					return e.getType();
				}
			}
		} catch ( Exception e ) {
			return null;
		}
		return null;
	}

	public static String getNameByType( Class<?> c, int type ) {
		try {
			EnumMsg[] enumMsgs = ( EnumMsg[] ) c.getMethod( "values" ).invoke(
					null );
			for ( EnumMsg e : enumMsgs ) {
				if ( e.getType() == type ) {
					return e.getName();
				}
			}
		} catch ( Exception e ) {
			return null;
		}
		return null;
	}

	public static Map<Integer, Object> getAllToMap( Class<?> clazz )
			throws Exception {
		Map<Integer, Object> returnMap = new HashMap<>();
		for ( Object object : clazz.getEnumConstants() ) {
			Method getName = object.getClass().getMethod( EnumMsg.GET_NAME );
			Method getType = object.getClass().getMethod( EnumMsg.GET_TYPE );
			returnMap.put( ( Integer ) getType.invoke( object ),
					getName.invoke( object ) );
		}
		return returnMap;
	}

	public static List<Map<String, Object>> getAllToList( Class<?> clazz ) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			for ( Object object : clazz.getEnumConstants() ) {
				Map<String, Object> enmuMap = new HashMap<>();
				Method getName = object.getClass().getMethod( EnumMsg.GET_NAME );
				Method getType = object.getClass().getMethod( EnumMsg.GET_TYPE );
				enmuMap.put( "type", getType.invoke( object ) );
				enmuMap.put( "name", getName.invoke( object ) );
				list.add( enmuMap );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		return list;
	}

	public static List<Map<String, Object>> getAllToListByExclusion(
			Class<?> clazz, List<Integer> exclusions ) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			for ( Object object : clazz.getEnumConstants() ) {
				Map<String, Object> enmuMap = new HashMap<>();
				Method getName = object.getClass().getMethod( EnumMsg.GET_NAME );
				Method getType = object.getClass().getMethod( EnumMsg.GET_TYPE );
				Object type = getType.invoke( object );
				if ( type instanceof Integer ) {
					if ( exclusions.contains( type ) )
						continue;
				}
				enmuMap.put( "type", type );
				enmuMap.put( "name", getName.invoke( object ) );
				list.add( enmuMap );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}

		return list;
	}

}