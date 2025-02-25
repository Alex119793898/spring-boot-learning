package com.caoliang.springboot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/users/queryAll", method = RequestMethod.GET)
    public List<Map<String, Object>> test(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from tb_user");
        return maps;
    }

    @RequestMapping(value = "/user/insert", method = RequestMethod.GET)
    public Boolean insert(String name, String password){
        if(StringUtils.isEmpty(name) || StringUtils.isEmpty(password)){
            return false;
        }

        jdbcTemplate.execute("insert into tb_user (`name`, `password`) value ( \"" + name + "\", \"" + password + "\")");
        return true;
    }
}
