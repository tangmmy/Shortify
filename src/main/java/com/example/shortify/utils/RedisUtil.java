package com.example.shortify.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Set;

/**
 * @author tangmingyi
 * @version RedisUtil.java, v 0.1 2025年10月26日 2:22 PM tangmingyi
 */
@Service
public class RedisUtil {
    private  final RedisTemplate<String,Object> redisTemplate ;

    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    public void save(String key,Object value,long time){

        redisTemplate.opsForValue().set(key,value, Duration.ofSeconds(time));
    }
    public  Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }
    public void delete(String key){
        redisTemplate.delete(key);
    }
    public void debugAllKeys() {
        Set<String> keys = redisTemplate.keys("*");
        for (String key : keys) {
            Object val = redisTemplate.opsForValue().get(key);
            System.out.println(key + " = " + val);
        }
    }
}