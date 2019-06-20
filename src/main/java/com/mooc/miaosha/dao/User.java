package com.mooc.miaosha.dao;

import com.sun.xml.internal.ws.developer.Serialization;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author fukang.yang 791934683@qq.com  fukang.yang@transwarp.io
 * @date 2019/6/19 15:36
 */
@Serialization
@Getter
@Setter
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class User {
    private int id;
    private String name;
}
