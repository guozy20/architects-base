package com.gupaoedu.design.principle.SRP.interfaced;

/**
 * @ProjectName gupao-design
 * @Classname CourseImpl
 * @Description TODO
 * @Date 2021/1/5 13:49
 * @Created by guoziyang
 */
public class CourseImpl implements ICourseInfo,ICourseManager {
    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public byte[] getCourseVideo() {
        return new byte[0];
    }

    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }
}
