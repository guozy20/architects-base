package com.gupaoedu.vip.design.principle.dip;

/**
 * 七大软件设计之--依赖倒置原则（Dependence Inversion Principle，DIP）
 * 定义：高层模块不应该依赖低层模块，二者都应该依赖其抽象
 *      抽象不应该依赖细节，细节应该依赖抽象
 *      针对接口编程，不用针对细节编程
 * 优点：可以减少类间的耦合性，提高系统稳定性，提高代码可读性和可维护性，可降低修改程序所造成的的风险
 */
public class DipTest {
    public static void main(String[] args) {
        /***  v1  ***/
//        Shines shines = new Shines();
//        shines.studyJavaCourse();
//        shines.studyPythonCourse();

        /***  v2  ***/
//        Shines shines = new Shines();
//        shines.study(new JavaCourse());
//        shines.study(new PythonCourse());

        /***  v3  ***/
//        Shines shines = new Shines(new JavaCourse());
//        shines.study();
//
//        Shines shines1 = new Shines(new PythonCourse());
//        shines1.study();

        /***  v4  ***/
        Shines shines = new Shines();
        shines.setCourse(new JavaCourse());
        shines.study();

        shines.setCourse(new PythonCourse());
        shines.study();

    }
}
