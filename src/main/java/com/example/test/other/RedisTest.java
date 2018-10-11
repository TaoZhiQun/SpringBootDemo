package com.example.test.other;

import redis.clients.jedis.Jedis;

/**
 * @author Tao
 */
public class RedisTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 58.87.121.20
        Jedis jedis = new Jedis("192.168.103.61",6379);
        jedis.connect();
        for(int i=0;i<10000;i++){
            jedis.set("tao","zhiqun");
        }
        long end = System.currentTimeMillis();
        System.out.println("执行1万次，耗时"+(end-start)+"毫秒");
    }
}
