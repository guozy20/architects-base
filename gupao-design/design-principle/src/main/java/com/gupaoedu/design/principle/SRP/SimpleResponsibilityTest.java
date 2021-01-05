package com.gupaoedu.design.principle.SRP;

import com.gupaoedu.design.principle.SRP.simple.LiveCourse;
import com.gupaoedu.design.principle.SRP.simple.ReplayCourse;

/**
 * @ProjectName gupao-design
 * @Classname SimpleResponsibilityTest
 * @Description TODO
 * @Date 2021/1/4 18:26
 * @Created by guoziyang
 */
public class SimpleResponsibilityTest {
    public static void main(String[] args) {
//        Course course = new Course();
//        course.study("直播课");
//        course.study("录播课");
        LiveCourse liveCourse = new LiveCourse();
        liveCourse.study("直播课");

        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("录播课");
    }
}
