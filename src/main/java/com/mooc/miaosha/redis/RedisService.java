package com.mooc.miaosha.redis;

import com.alibaba.fastjson.JSON;
import com.mooc.miaosha.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author fukang.yang 791934683@qq.com  fukang.yang@transwarp.io
 * @date 2019/6/4 17:00
 */
@Service
public class RedisService {
    @Autowired
    JedisPool jedisPool;
    //set object
    public <T> boolean set(KeyPrefix prefix,String key,T value){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String str = beanToString(value);
            if (str ==null||str.length()<=0){
                return  false;
            }
            String reaKey = prefix.getPrefix()+key;
            int seconds =prefix.expireSeconds();
            if (seconds<=0){
                jedis.set(reaKey,str);
            }else {
                jedis.setex(reaKey,seconds,str);
            }
            return true;
        }finally {
            returnToPool(jedis);
        }
    }

    private <T> String beanToString(T value) {
        if (value == null){
            return null;
        }
        Class<?> clazz = value.getClass();
        if (clazz == int.class||clazz==Integer.class){
            return  ""+value;
        }else if(clazz == String.class){
            return(String)value;
        }else  if(clazz == long.class || clazz ==Long.class){
            return  ""+value;
        }else {
            return JSON.toJSONString(value);
        }

    }

    //get object
    public <T> T get(KeyPrefix prefix,String key,Class<T> clazz){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String realKey = prefix.getPrefix()+key;
            String str =jedis.get(realKey);
            T t = stringToBean(str,clazz);
            return t;
        }finally {
            returnToPool(jedis);
        }
    }

    private <T> T stringToBean(String str , Class<T> clazz){
        if (str==null||str.length()<=0||clazz==null){
            return null;
        }
        if (clazz == int.class||clazz==Integer.class){
            return  (T)Integer.valueOf(str);
        }else if(clazz == String.class){
            return (T)str;
        }else  if(clazz == long.class || clazz ==Long.class){
            return  (T)Long.valueOf(str);
        }
//        else  if(clazz == User.class ){
//            return  (T)new User(1,str);
//        }
        else {
            return JSON.toJavaObject(JSON.parseObject(str),clazz);
        }
    }

    private void returnToPool(Jedis jedis){
        if (jedis!=null){
            jedis.close();
        }
    }

    public <T> boolean exists(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String reaKey = prefix.getPrefix()+key;
            return jedis.exists(reaKey);
        }finally {
            returnToPool(jedis);
        }
    }
    //increase
    public <T> Long incr(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String reaKey = prefix.getPrefix()+key;
            return jedis.incr(reaKey);
        }finally {
            returnToPool(jedis);
        }
    }

    //decrease
    public <T> Long decr(KeyPrefix prefix,String key){
        Jedis jedis=null;
        try {
            jedis=jedisPool.getResource();
            String reaKey = prefix.getPrefix()+key;
            return jedis.decr(reaKey);
        }finally {
            returnToPool(jedis);
        }
    }

}
