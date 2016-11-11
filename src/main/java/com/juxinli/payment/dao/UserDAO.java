package com.juxinli.payment.dao;

import com.juxinli.payment.entity.UserEntity;

public interface UserDAO {
	
	UserEntity getUserById( Integer userId );

}
