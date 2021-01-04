package com.gupaoedu.design.principle.DIP;

/**
 * @ProjectName gupao-design
 * @Classname Tom
 * @Description TODO
 * @Date 2021/1/4 15:40
 * @Created by guoziyang
 */
public class Tom {
    private ICourse course;
    public void setCourse(ICourse course) {
        this.course = course;
    }
    public void study(){
        course.study();
    }
    /*private ICourse course;
    public Tom(ICourse course) {
        this.course = course;
    }
    public void study(){
        course.study();
    }*/

    /*public void studyJavaCourse(){
        System.out.println("tom在学java架构课");
    }
    public void studyPythonCourse(){
        System.out.println("tom在学Python的课程");
    }
    public void study(ICourse course){
        course.study();
    }*/
}
