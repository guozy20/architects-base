package com.guozy.thread.example.springbootthreaddemo.controller;

import com.guozy.thread.example.springbootthreaddemo.persistence.User;
import com.guozy.thread.example.springbootthreaddemo.service.IUserService;
import com.guozy.thread.example.springbootthreaddemo.utils.SendSmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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


    ExecutorService executorService = Executors.newFixedThreadPool(10);

    @PostMapping("/sms/user")
    public String register(User user){
        long start = System.currentTimeMillis();

        userService.insert(user);
        // 异步调用,生产不建议用这样
        // 会产生N多个线程，可以采用线程池的方式创建
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    SendSmsUtils.sendMessage("18514030120");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
       /* new Thread(()->{
            try {
                SendSmsUtils.sendMessage("18514030120");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();*/

        long end = System.currentTimeMillis();
        return "success:" + (end - start);
    }

    public static String post(String url, Map<String, String> params) {
       return null;

    }
}
