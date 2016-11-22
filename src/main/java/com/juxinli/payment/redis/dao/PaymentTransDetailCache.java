package com.juxinli.payment.redis.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.juxinli.payment.core.cache.AbstractBaseRedisDAO;
import com.juxinli.payment.core.exception.PaymentException;
import com.juxinli.payment.domain.PaymentTransDetailEntity;

public class PaymentTransDetailCache extends
		AbstractBaseRedisDAO<String, PaymentTransDetailEntity> {

	public boolean add( final PaymentTransDetailEntity paymentTransDetail ) {
		boolean result = redisTemplate.execute( new RedisCallback<Boolean>() {
			public Boolean doInRedis( RedisConnection connection )
					throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] key = serializer.serialize( paymentTransDetail.getRedisKey() );
				byte[] name = serializer.serialize( paymentTransDetail.getRedisValue() );
				return connection.setNX( key, name );
			}
		});
		return result;
	}

	public void delete( String key ) {
		List<String> list = new ArrayList<String>();
		list.add( key );
		delete( list );
	}

	public boolean update( final PaymentTransDetailEntity paymentTransDetail ) throws PaymentException {
		String key = paymentTransDetail.getRedisKey();
		if ( get( key ) == null ) {
			throw new PaymentException( "数据行不存在, key = " + key );
		}
		boolean result = redisTemplate.execute( new RedisCallback<Boolean>() {
			public Boolean doInRedis( RedisConnection connection )
					throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] key = serializer.serialize( paymentTransDetail.getRedisKey() );
				byte[] name = serializer.serialize( paymentTransDetail.getRedisValue() );
				connection.set( key, name );
				return true;
			}
		} );
		return result;
	}
	
	public void delete( List<String> keys ) {
		redisTemplate.delete( keys );
	}

	public PaymentTransDetailEntity get( final String keyId ) {
		PaymentTransDetailEntity result = redisTemplate
				.execute( new RedisCallback<PaymentTransDetailEntity>() {
					public PaymentTransDetailEntity doInRedis(
							RedisConnection connection )
							throws DataAccessException {
						RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
						byte[] key = serializer.serialize( keyId );
						byte[] value = connection.get( key );
						if ( value == null ) {
							return null;
						}
						return new PaymentTransDetailEntity( key, value );
					}
				} );
		return result;
	}

}
