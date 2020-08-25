package com.gupaoedu.vip.design.principle.srp;

import org.omg.CORBA.INV_FLAG;

public class Course {
    public void study(String courseName) {
        if ("直播课程".equals(courseName)) {
            System.out.println("不能快进");
        } else {
            System.out.println("可以任意的来回播放");
        }
    }
}
