package com.mooc.miaosha.redis;

/**
 * @author fukang.yang 791934683@qq.com  fukang.yang@transwarp.io
 * @date 2019/6/19 15:07
 */
public class UserKey  extends BasePrefix{
    private UserKey(String prefix){
        super(0,prefix);
    }

    public static UserKey getByid=new UserKey("id");
    public static UserKey getByName = new UserKey("name");

}
