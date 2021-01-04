package com.gupaoedu.design.principle.DIP;

/**
 * @ProjectName gupao-design
 * @Classname JavaCourse
 * @Description TODO
 * @Date 2021/1/4 15:53
 * @Created by guoziyang
 */
public class AICourse implements ICourse {
    @Override
    public void study() {
        System.out.println("tom在学习AI课程");
    }
}
