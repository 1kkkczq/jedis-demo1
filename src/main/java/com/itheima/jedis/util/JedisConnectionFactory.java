package com.itheima.jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description TODO
 * @authorKKK
 * @date2023/2/2616:35
 * @version1.0
 */
public class JedisConnectionFactory {
    private static final JedisPool jedisPool;

    static {
        //配置连接池
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        //最大连接数
        poolConfig.setMaxTotal(8);
        //最大空闲连接
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(0);
        //等待时间
        poolConfig.setMaxWaitMillis(1000);
        //创建连接池对象
        jedisPool = new JedisPool(poolConfig ,
                "192.168.101.65" , 6379 ,1000,"123321");
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
