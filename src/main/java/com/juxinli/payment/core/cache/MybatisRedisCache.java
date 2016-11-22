package com.juxinli.payment.core.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MybatisRedisCache implements Cache {

	private static Logger logger = LoggerFactory
			.getLogger( MybatisRedisCache.class );
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private String id;

	public MybatisRedisCache( final String id ) {
		if ( id == null ) {
			throw new IllegalArgumentException( "Cache instances require an ID" );
		}
		logger.debug( ">>>>>>>>>>>>>>>>>>>>>>>>MybatisRedisCache:id=" + id );
		this.setId( id );
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getObject( Object arg0 ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public void putObject( Object arg0, Object arg1 ) {

	}

	@Override
	public Object removeObject( Object arg0 ) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId( String id ) {
		this.id = id;
	}

}
