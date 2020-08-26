package com.guozy.thread.example.springbootthreaddemo;

public class ThreadDemo extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("come in");
    }

    public static void main(String[] args) {
        ThreadDemo testDemo = new ThreadDemo();
        testDemo.start();
        System.out.println("Main thread");
    }
}
