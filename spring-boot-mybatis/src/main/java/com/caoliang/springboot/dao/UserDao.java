package com.caoliang.springboot.dao;

import com.caoliang.springboot.entity.User;

import java.util.List;


public interface UserDao {

    public List<User> queryAll();

    public int insert(User user);


    public int update(User user);

    public int remove(String id);
}
