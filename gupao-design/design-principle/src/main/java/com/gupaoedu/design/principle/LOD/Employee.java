package com.gupaoedu.design.principle.LOD;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName gupao-design
 * @Classname Employee
 * @Description TODO
 * @Date 2021/1/6 10:52
 * @Created by guoziyang
 */
public class Employee {
    public void checkNumberOfCourses(){
        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < 20; i++) {
            courseList.add(new Course());
        }
        System.out.println("目前已发布的课程数量是：" + courseList.size());
    }
}
