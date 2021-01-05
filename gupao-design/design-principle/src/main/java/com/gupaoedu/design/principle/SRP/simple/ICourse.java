package com.gupaoedu.design.principle.SRP.simple;

/**
 * @ProjectName gupao-design
 * @Classname ICourse
 * @Description TODO
 * @Date 2021/1/5 11:40
 * @Created by guoziyang
 */
public interface ICourse {
    // 获取基本信息
    String getCourseName();

    // 获取视频流
    byte[] getCourseVideo();

    // 学习课程
    void studyCourse();

    // 退款
    void refundCourse();

}
