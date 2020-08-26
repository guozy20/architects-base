package com.guozy.thread.example.springbootthreaddemo.demo02;

import java.util.concurrent.TimeUnit;

public class Demo2 {
    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                try {
                    // 线程睡眠
                    TimeUnit.SECONDS.sleep(100);
//                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "STATUS_01").start(); // 阻塞状态 TIMED_WAITING

        new Thread(() -> {
            while (true) {
                try {
                    synchronized (Demo2.class) {
                        Demo2.class.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "STATUS_02").start(); // 阻塞状态 WAITING


        new Thread(new BlocledDemo(), "BlockedDemo-demo-01").start();
        new Thread(new BlocledDemo(), "BlockedDemo-demo-02").start();
    }

    static class BlocledDemo extends Thread {
        @Override
        public void run() {
            synchronized (BlocledDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
