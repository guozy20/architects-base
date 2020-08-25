package com.gupaoedu.vip.design.principle.openclose;

/**
 * 七大软件设计原则之--开闭原则（Open-Close Principle，OCP）
 * 定义：一个软件实体如类、模块和函数应该对外扩展开放，对修改关闭。
 *      用抽象构建架构，用实现扩展细节
 * 优点：提高软件系统的可复用性及可维护性
 */
public class OpenCloseTest {

    public static void main(String[] args) {
        ICourse iCourse = new JavaDiscountCourse(1,"Java架构",11800D);
        JavaDiscountCourse discountCourse = (JavaDiscountCourse)iCourse;
        System.out.println("课程ID：" + discountCourse.getId() +
                "\n课程标题：《" +  discountCourse.getName() + "》" +
                "\n原价：" + discountCourse.getPrice() +
                "\n售价：" + discountCourse.getDiscountPrice());
    }
}
