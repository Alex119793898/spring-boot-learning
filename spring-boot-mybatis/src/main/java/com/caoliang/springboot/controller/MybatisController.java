package com.caoliang.springboot.controller;

import com.caoliang.springboot.dao.UserDao;
import com.caoliang.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MybatisController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/queryAll")
    @ResponseBody
    public List<User> querAll(){
        List<User> users = userDao.queryAll();
        return users;
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    @ResponseBody
    public Boolean insertUser(@RequestBody User user){
        int i = userDao.insert(user);
        return i > 0;
    }

    @RequestMapping(value="/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public Boolean updateUser(@RequestBody User user){
        int i = userDao.update(user);
        return i > 0;
    }

    @RequestMapping(value = "/removeUser", method = RequestMethod.POST)
    @ResponseBody
    public Boolean removeUser(@RequestBody String id){
        int i = userDao.remove(id);
        return i > 0;
    }
}
