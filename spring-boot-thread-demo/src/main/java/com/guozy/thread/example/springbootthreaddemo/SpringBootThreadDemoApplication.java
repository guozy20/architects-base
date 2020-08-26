package com.guozy.thread.example.springbootthreaddemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.guozy.thread.example.springbootthreaddemo.persistence")
@SpringBootApplication
public class SpringBootThreadDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootThreadDemoApplication.class, args);
    }

}
