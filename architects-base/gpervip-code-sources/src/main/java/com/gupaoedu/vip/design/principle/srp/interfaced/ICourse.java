package com.gupaoedu.vip.design.principle.srp.interfaced;

public interface ICourse {
    String getCourseName();
    byte[] getCourseVideo();

    void studyCourse();
    void refundCourse();
}
