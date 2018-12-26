package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisClientTemplate{
    private static final Logger log=LoggerFactory.getLogger(RedisClientTemplate.class);

    @Autowired
    private JedisClusterConfig jedisClusterConfig;

    public boolean setKey(String key,String value){
        String result = jedisClusterConfig.getJedisCluster().set(key, value);
        if("OK".equals(result)){
            return true;
        }else {
            log.error("setToRedis:{Key:"+key+",value"+value+"}");
            return false;
        }
    }

    public String getKey(String key){
        String value = jedisClusterConfig.getJedisCluster().get(key);
        return value;
    }


}
