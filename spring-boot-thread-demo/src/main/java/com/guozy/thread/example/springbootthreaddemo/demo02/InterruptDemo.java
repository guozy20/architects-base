package com.guozy.thread.example.springbootthreaddemo.demo02;

public class InterruptDemo implements Runnable {

    private int i = 1;

    @Override
    public void run() {
        // Thread.currentThread().isInterrupted()=false 默认等于false
        // 表示一个中断的标记，interrupt=fasle
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Test:"+ i++);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new InterruptDemo);
        thread.start();
//        thread.stop(); // 不建议使用
        thread.interrupt(); // 设置interrupt=true
    }
}
