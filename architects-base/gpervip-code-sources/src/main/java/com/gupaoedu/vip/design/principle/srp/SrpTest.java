package com.gupaoedu.vip.design.principle.srp;

/**
 * 七大软件设计原则之--单一职责原则（Simple Responsibility Principle，RSP）
 * 定义：不要存在多余一个导致类变更的原因
 *      一个类、接口、方法只负责一项职责
 * 优点：降低类的复杂度
 *      提高类的可读性
 *      提高系统的可维护性
 *      降低变更引起的风险
 */
public class SrpTest {

    public static void main(String[] args) {
//        Course course = new Course();
//        course.study("直播课程");
//        course.study("录播课程");

        LiveCourse liveCourse = new LiveCourse();
        liveCourse.study( "直播课程");

        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("录播课程");

    }
}
