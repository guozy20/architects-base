package com.guozy.thread.example.springbootthreaddemo.service;

import com.guozy.thread.example.springbootthreaddemo.persistence.User;
import com.guozy.thread.example.springbootthreaddemo.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
