package com.guozy.design.principle.srp;

public class Course {
    public void study(String courseName) {
        if ("直播课程".equals(courseName)) {
            System.out.println("不能快进");
        } else {
            System.out.println("可以任意的来回播放");
        }
    }
}
