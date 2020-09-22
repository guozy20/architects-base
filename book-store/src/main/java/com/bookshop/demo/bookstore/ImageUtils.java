package com.bookshop.demo.bookstore;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;


/**
 * @BelongsProject: huxidao2_one_svn3
 * @BelongsPackage: PACKAGE_NAME
 * @Author: gaoshaomeng
 * @CreateTime: 2020-05-21 09:56
 * @Description: ${Description}
 */
public class ImageUtils {

    public static void main(String args[]) throws UnsupportedEncodingException, InterruptedException {
        final Account a = new Account().setBalance(200);
        final Account b = new Account().setBalance(200);
        final Account c = new Account().setBalance(200);

        System.out.println(a.getBalance());
        System.out.println(b.getBalance());
        System.out.println(c.getBalance());

        final CountDownLatch count = new CountDownLatch(3000);
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
