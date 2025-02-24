package com.caoliang.springboot.swagger.controller;

import com.caoliang.springboot.swagger.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Tag(name = "用户模块接口")
@RestController
public class UserModuleController {

    static Map<Integer, User> usersMap = Collections.synchronizedMap(new HashMap<Integer, User>());

    static {
        User user1 = new User();
        user1.setId(1);
        user1.setName("zhangsan");
        user1.setPassword("123456");
        User user2 = new User();
        user2.setId(2);
        user2.setName("lisi");
        user2.setPassword("abcdef");
        usersMap.put(1,user1);
        usersMap.put(2,user2);
    }

    @Operation(summary = "获取用户列表")
    @GetMapping("/users")
    public List<User> getUserList(){
        ArrayList<User> users = new ArrayList<>(usersMap.values());
        return users;
    }


}
