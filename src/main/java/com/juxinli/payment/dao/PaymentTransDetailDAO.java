package com.juxinli.payment.dao;

import java.util.Map;

import com.juxinli.payment.domain.PaymentTransDetailEntity;

public interface PaymentTransDetailDAO {
	
	Integer insert( PaymentTransDetailEntity entity );

	PaymentTransDetailEntity selectByPrimaryKey( Map<String, Object> params );

}
