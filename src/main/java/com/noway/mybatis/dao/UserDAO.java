package com.noway.mybatis.dao;

import com.noway.mybatis.entity.UserEntity;

public interface UserDAO {
	
	UserEntity getUserById( Integer userId );

}
