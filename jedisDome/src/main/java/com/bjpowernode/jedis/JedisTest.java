package com.bjpowernode.jedis;

import redis.clients.jedis.Jedis;

/***
 *@：使用jedis操作redis
 */


public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.233.111", 6379);
        jedis.flushAll();

        jedis.set("str1","aaa");
        String str1 = jedis.get("str1");
        System.out.println(str1);
        jedis.append("str1","bbb");
        String str11 = jedis.get("str1");
        System.out.println(str11);


        jedis.close();

    }
}
