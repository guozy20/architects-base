package com.gupaoedu.design.principle.OCP;


/**
 * @ProjectName gupao-design
 * @Classname OpenClosePrincipleTest
 * @Description TODO
 * @Date 2021/1/4 13:57
 * @Created by guoziyang
 */
public class OpenClosePrincipleTest {

    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(1,"Java架构",11800D);
        JavaDiscountCourse discountCourse = (JavaDiscountCourse)iCourse;
        System.out.println("课程ID：" + discountCourse.getID() +
                "\n课程标题：《" +  discountCourse.getName() + "》" +
                "\n原价：" + discountCourse.getPrice() +
                "\n售价：" + discountCourse.getDiscountPrice());
    }

}
