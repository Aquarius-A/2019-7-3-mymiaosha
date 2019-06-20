package com.mooc.miaosha.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author fukang.yang 791934683@qq.com  fukang.yang@transwarp.io
 * @date 2019/6/20 10:28
 */
public class MD5Util {
    private static final String salt = "1a2b3c4d";

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    public static String inputPassToFromPass(String inputPass){
        String str = ""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }
    public static String FromPassToDBPass(String formPass,String inputPass){
        String str = ""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }
    public static String inputPassToDbPass(String input,String saltDB){
        String formPass = inputPassToFromPass(input);
        String dbPass = FromPassToDBPass(formPass,saltDB);
        return dbPass;
    }
}
