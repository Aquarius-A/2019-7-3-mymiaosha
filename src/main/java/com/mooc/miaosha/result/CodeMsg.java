package com.mooc.miaosha.result;

/**
 * @author fukang.yang
 * @date 2019/5/29 10:00
 */
public class CodeMsg {
    private int code;
    private String msg;

    //通用异常
    /**
        *description
        *
     * @param null
        *@return 
     */
    public static CodeMsg SUCCESS = new CodeMsg(0,"success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务段异常");

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
