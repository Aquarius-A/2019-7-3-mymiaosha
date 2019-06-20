package com.mooc.miaosha.redis;

/**
 * @author fukang.yang 791934683@qq.com  fukang.yang@transwarp.io
 * @date 2019/6/19 14:50
 */
public interface KeyPrefix {
    public  int expireSeconds();
    public String getPrefix();
}
