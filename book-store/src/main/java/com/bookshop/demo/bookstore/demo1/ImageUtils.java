package com.bookshop.demo.bookstore.demo1;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;



public class ImageUtils {

    public static void main(String args[]) throws UnsupportedEncodingException, InterruptedException {
        final Account a = new Account().setBalance(10000);
        final Account b = new Account().setBalance(10000);
        final Account c = new Account().setBalance(10000);

        System.out.println(a.getBalance());
        System.out.println(b.getBalance());
        System.out.println(c.getBalance());

        final CountDownLatch count = new CountDownLatch(30000);
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    a.transfer(b, 100);
                    count.countDown();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    b.transfer(c, 100);
                    count.countDown();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    c.transfer(a, 100);
                    count.countDown();
                }
            }).start();
        }
        count.await();
        System.out.println(a.getBalance());
        System.out.println(b.getBalance());
        System.out.println(c.getBalance());


    }
}
