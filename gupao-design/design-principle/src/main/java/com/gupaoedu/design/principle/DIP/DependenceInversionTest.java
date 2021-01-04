package com.gupaoedu.design.principle.DIP;

/**
 * @ProjectName gupao-design
 * @Classname DIPTest
 * @Description TODO
 * @Date 2021/1/4 15:42
 * @Created by guoziyang
 */
public class DependenceInversionTest {
    public static void main(String[] args) {
       /* Tom tom = new Tom();
//        tom.studyJavaCourse();
//        tom.studyPythonCourse();
        tom.study(new JavaCourse());
        tom.study(new PythonCourse());*/

      /* Tom tom = new Tom(new JavaCourse());
       tom.study();*/
      Tom tom = new Tom();
      tom.setCourse(new JavaCourse());
      tom.study();

      tom.setCourse(new PythonCourse());
      tom.study();

        tom.setCourse(new AICourse());
        tom.study();
    }
}

