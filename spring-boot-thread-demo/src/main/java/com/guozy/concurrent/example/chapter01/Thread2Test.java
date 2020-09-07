package com.guozy.concurrent.example.chapter01;

import java.util.concurrent.TimeUnit;

public class Thread2Test {
    public static void main(String[] args) {
        new Thread(Thread2Test::browseNews).start();
        browseNews();

//        new Thread(){
//            @Override
//            public void run() {
//                enjoyMusic();
//            }
//        }.start();
//        browseNews();
    }

    /**
     * 看新闻
     */
    private static void browseNews() {
        for (; ; ) {
            System.out.println("Uh-huh, the good news");
            sleep(1);
        }
    }

    /**
     * 听音乐
     */
    private static void enjoyMusic() {
        for (; ; ) {
            System.out.println("Uh-huh, the nice music");
            sleep(1);
        }
    }

    /**
     * 睡眠
     * @param seconds
     */
    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
