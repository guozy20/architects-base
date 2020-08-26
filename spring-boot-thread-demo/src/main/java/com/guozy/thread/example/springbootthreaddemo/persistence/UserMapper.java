package com.guozy.thread.example.springbootthreaddemo.persistence;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insert(User user);
}
