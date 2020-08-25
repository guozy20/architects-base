package com.guozy.design.principle.lsp;

/**
 * 七大软件设计原则之--里氏替换原则（Liskov Substitution Principle，LSP）
 * 定义：如果对每一个类型为T1的对象o1，都有类型为T2的对象o2，是得以T1定义的所有程序P所在的
 *      对象o1都替换成o1时，程序P的行为没有发生变化，那么类型T2是类型T1的子类型
 * 定义扩展：一个软件实体如果适用一个父类的话，那一定适用于其子类，所有引用父类的地方必须能
 *          透明地使用其子类的对象，子类对象能够替换父类对象，而程序逻辑不变。
 * 引申定义：子类可以扩展父类的功能，但不能改变父类原有的功能。
 * 含义1：子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法。
 * 含义2：子类中可以增加自己特有的方法。
 * 含义3：当子类的方法重载父类的方法时，方法的前置条件（及方法的输入，入参）要比父类方法的输入参数更宽松。
 * 含义4：当子类的方法实现父类的方法时（重写、重载或实现抽象方法），方法的后置
 *        条件（及方法的输出、返回值）要比父类更严格或相等。
 *  有点1：约束继承泛滥，开闭原则的一种体现。
 *  优点：加强程序的健壮性，同时变更时也可以做到非常好的兼容性
 *        提高程序的维护性，扩展性。降低需求变更时引入的风险。
 */
public class IspleTest {

    public static void resize(Rectangle quadRangle){
        while(quadRangle.getWidth() >= quadRangle.getHeight()){
            quadRangle.setHeight(quadRangle.getWidth() + 1);
            System.out.println("width：" + quadRangle.getWidth() + ",height:" + quadRangle.getHeight());
        }
        System.out.println("Resize end,width：" + quadRangle.getWidth() + ",height:" + quadRangle.getHeight());

    }
    public static void main(String[] args) {
//        Rectangle rectangle = new Rectangle();
//        rectangle.setHeight(10);
//        rectangle.setWidth(20);
//        resize(rectangle);
//        Square square = new Square();
//        square.setLength(20);
//        resize(square);
    }
}
