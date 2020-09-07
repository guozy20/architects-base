package com.guozy.thread.example;

import org.openjdk.jol.info.ClassLayout;

/**
 * 打印类的布局
 */
public class ClasslayOutDemo {
    public static void main(String[] args) {
        ClasslayOutDemo classlayOutDemo = new ClasslayOutDemo();
        synchronized (classlayOutDemo) {
            System.out.println("locking");
            System.out.println(ClassLayout.parseInstance(classlayOutDemo).toPrintable());
        }
    }
}
