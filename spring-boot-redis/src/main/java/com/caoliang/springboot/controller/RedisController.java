package com.caoliang.springboot.controller;

import com.caoliang.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/addStringToRedis")
    @ResponseBody
    public Boolean addStringToRedis(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
        return true;
    }

    @RequestMapping("/getStringForRedis")
    @ResponseBody
    public String getStringForRedis(String key){
        String s = stringRedisTemplate.opsForValue().get(key);
        return s;
    }

    @RequestMapping("/addUserToRedis")
    @ResponseBody
    public Boolean addUserToRedis(String name, String password){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        redisTemplate.opsForValue().set(name, user);
        return true;
    }

    @RequestMapping("/getUserFromRedis")
    @ResponseBody
    public User getUserFromRedis(String name){
        return (User) redisTemplate.opsForValue().get(name);
    }

    @RequestMapping("/removeUserFromRedis")
    @ResponseBody
    public Boolean removeUserFromRedis(String name){
        return redisTemplate.delete(name);
    }


}
