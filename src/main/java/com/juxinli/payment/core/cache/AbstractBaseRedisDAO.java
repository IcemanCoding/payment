package com.juxinli.payment.core.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractBaseRedisDAO<K, V> {  
    
    @Autowired  
    protected StringRedisTemplate redisTemplate;  
  
    /** 
     * 设置redisTemplate 
     * @param redisTemplate the redisTemplate to set 
     */  
    public void setRedisTemplate(StringRedisTemplate redisTemplate) {  
        this.redisTemplate = redisTemplate;  
    }  
      
}  