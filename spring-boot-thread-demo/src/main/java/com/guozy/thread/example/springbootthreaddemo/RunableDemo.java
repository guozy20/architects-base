package com.guozy.thread.example.springbootthreaddemo;

public class RunableDemo implements Runnable{
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
        RunableDemo runableDemo = new RunableDemo();
        runableDemo.run();
        System.out.println("main thread");
    }
}
