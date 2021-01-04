package com.gupaoedu.design.principle.SRP;

/**
 * @ProjectName gupao-design
 * @Classname Course
 * @Description TODO
 * @Date 2021/1/4 18:23
 * @Created by guoziyang
 */
public class Course {
    public void study(String courseName) {
        if ("直播课".equals(courseName)) {
            System.out.println("直播课不能快进");
        }else {
            System.out.println("录播课可以任意的来回播放");
        }
    }
}
