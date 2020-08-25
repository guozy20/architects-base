package com.guozy.design.principle.lod;

/**
 * 七大软件设计原则之--迪米特法则（Law of Demeter，LoD），也叫最少知道原则（Least Knowledge Principle，LKP）
 * 定义：一个类应该对其他对象保持最少的了解，又叫最少知道原则
 *      尽量降低类于类之间的耦合
 * 优点：降低类之间的耦合
 */
public class IodTest {
    public static void main(String[] args) {
        TeamLeader teamLeader = new TeamLeader();
        Employee employee = new Employee();
        teamLeader.commandCheckNumber(employee);
    }
}
