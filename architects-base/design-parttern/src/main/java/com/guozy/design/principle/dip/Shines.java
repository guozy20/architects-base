package com.guozy.design.principle.dip;

public class Shines {
//    public void studyJavaCourse() {
//        System.out.println("Shines正在学习java课程");
//    }
//
//    public void studyPythonCourse() {
//        System.out.println("Shines正在学习Python课程");
//    }

    private ICourse course;

    public void setCourse(ICourse course) {
        this.course = course;
    }
    //    public Shines(ICourse course) {
//        this.course = course;
//    }

    public void study() {
        course.study();
    }
}
