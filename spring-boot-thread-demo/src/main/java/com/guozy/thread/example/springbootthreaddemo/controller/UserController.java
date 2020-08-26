package com.guozy.thread.example.springbootthreaddemo.controller;

import com.guozy.thread.example.springbootthreaddemo.persistence.User;
import com.guozy.thread.example.springbootthreaddemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping("/user")
    public String test(User user){
        long start = System.currentTimeMillis();
        userService.insert(user);
        long end = System.currentTimeMillis();
        return "success:" + (end - start);
    }

    @PostMapping("/test")
    public String register(User user){

        return null;
    }
}
