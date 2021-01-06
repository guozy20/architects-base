package com.gupaoedu.design.principle.ISP.Segregation;

import com.gupaoedu.design.principle.ISP.simple.IAnimal;

/**
 * @ProjectName gupao-design
 * @Classname Bird
 * @Description TODO
 * @Date 2021/1/5 14:22
 * @Created by guoziyang
 */
public class Bird implements IEatAnimal, IFlyAnimal {
    @Override
    public void eat() {

    }
    @Override
    public void fly() {

    }
}
