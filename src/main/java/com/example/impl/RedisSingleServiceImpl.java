package com.example.impl;

import com.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

@Service(value = "redisService")
public class RedisSingleServiceImpl implements RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, String value) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
    }

    @Override
    public String get(String key) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String value = (String) valueOperations.get(key);
        return value;
    }

    @Override
    public void del(String key) {
        redisTemplate.delete(key);
    }


    private RedisSerializer<String> getRedisSerializer() {
        return redisTemplate.getStringSerializer();
    }
}
