package com.heima.test;

import com.itheima.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @description TODO
 * @authorKKK
 * @date2023/2/2614:11
 * @version1.0
 */

public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp(){
        //建立连接
//      jedis = new Jedis("192.168.101.65" , 6379);
        jedis = JedisConnectionFactory.getJedis();
        //设置密码
        jedis.auth("123321");
        //选择库
        jedis.select(1);


    }

    @Test
    void testString(){
        //存入数据
        String result = jedis.set("name", "虎哥");

        System.out.println(result);
        //获取数据
        String name = jedis.get("name");
        System.out.println(name);

    }

    @Test
    void testHash(){
        //插入hash数据
        jedis.hset("user:1" , "name" , "jack");
        jedis.hset("user:1" , "age" , "21");

        //获取
        Map<String, String> map = jedis.hgetAll("user:1");
        System.out.println(map);

    }

    @AfterEach
    void tearDown(){
        if(jedis != null){
            jedis.close();
        }
    }
}
