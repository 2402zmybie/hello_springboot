package com.hr.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        //string字符串
//        redisTemplate.opsForValue().set("str","hr");
        redisTemplate.boundValueOps("str").set("hr");
        System.out.println("str=" + redisTemplate.opsForValue().get("str"));

        //hash散列
        redisTemplate.boundHashOps("h_keys").put("name", "hr");
        redisTemplate.boundHashOps("h_keys").put("age", 13);
        //获取所有域
        Set set = redisTemplate.boundHashOps("h_keys").keys();
        System.out.println("hash散列的所有域:" + set);
        //获取所有值
        List list = redisTemplate.boundHashOps("h_keys").values();
        System.out.println("hash散列的所有值:" + list);

        //list列表
        redisTemplate.boundListOps("l_keys").leftPush("c");
        redisTemplate.boundListOps("l_keys").leftPush("b");
        redisTemplate.boundListOps("l_keys").leftPush("a");
        //获取全部元素
        List lKeys = redisTemplate.boundListOps("l_keys").range(0, -1);
        System.out.println("list列表的所有值:" + lKeys);

        //set集合
        redisTemplate.boundSetOps("s_keys").add("a","b","c");
        Set sKeys = redisTemplate.boundSetOps("s_keys").members();
        System.out.println("set集合的所有值:" + sKeys);

        //sorted set有序集合
        redisTemplate.boundZSetOps("z_keys").add("a", 30);
        redisTemplate.boundZSetOps("z_keys").add("b", 20);
        redisTemplate.boundZSetOps("z_keys").add("c", 10);
        Set zKeys = redisTemplate.boundZSetOps("z_keys").range(0, -1);
        System.out.println("zset有序集合的所有值:" + zKeys);
    }
}
