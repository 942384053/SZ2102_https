package com.bjpowernode.jedis;

import com.bjpowernode.util.RedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

/***
 * @:使用连接池创建对象
 */

public class jedisPoolTest {
    public static void main(String[] args) {
        //1.打开连接池对象
        JedisPool jedisPool = RedisUtils.open("192.168.233.111", 6379);
        //2.从连接池拿到一个jedis对象资源
        Jedis jedis = jedisPool.getResource();
        jedis.flushAll();
        Transaction multi = jedis.multi();
        multi.set("str4","aaa");
        multi.set("str5","aaa");
        multi.set("str6","aaa");

        multi.exec();
        jedisPool.close();
    }
}
