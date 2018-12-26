package com.example.util;

import com.example.config.JedisClusterConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisLockMager {
    @Autowired
    private JedisClusterConfig jedisClusterConfig;

    //设置1秒过期
    private static final int DEFAULT_SINGLE_EXPIRE_TIME = 1;

    private static final Logger logger = LoggerFactory.getLogger(RedisLockMager.class);

    public  boolean tryGetDistributedLock(String lockKey) {
        try {
            return tryLock(lockKey, lockKey, 0L, null);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean tryLock(String key, String value, long timeout, TimeUnit unit) throws InterruptedException {
        long begin = System.nanoTime();
        do {
            Long setnx = jedisClusterConfig.getJedisCluster().setnx(key, value);
            if (setnx == 1) {
                jedisClusterConfig.getJedisCluster().expire(key, DEFAULT_SINGLE_EXPIRE_TIME);
                logger.info(value + "-成功获取{}的锁,设置锁过期时间为{}秒 ", key, DEFAULT_SINGLE_EXPIRE_TIME);
                return true;
            }
            if (timeout == 0) {
                break;
            }
            Thread.sleep(100);
        } while ((System.nanoTime() - begin) < unit.toNanos(timeout));
        return false;
    }

    public void unLock(String key) {
        jedisClusterConfig.getJedisCluster().del(key);
    }

}
