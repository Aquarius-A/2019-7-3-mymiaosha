package com.mooc.miaosha.controller;

import com.mooc.miaosha.dao.User;
import com.mooc.miaosha.redis.RedisService;
import com.mooc.miaosha.redis.UserKey;
import com.mooc.miaosha.result.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Demo class
 *
 * @author yangfukang
 * @date 2019/5/29
 */

@Controller
@RequestMapping("/demo")
public class SampleController {


    @Autowired
    RedisService redisService;
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","shuai kankang");
        return "hello";
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet(){
        User v1=redisService.get(UserKey.getByid,""+2,User.class);
        return Result.success(v1);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet(){
        User user = new User(1,"111111");
        //boolean ret=
        redisService.set(UserKey.getByid,""+2,user);
        //String str=redisService.get(UserKey.getByid,"key2",String.class);
        return Result.success(true);
    }
}
