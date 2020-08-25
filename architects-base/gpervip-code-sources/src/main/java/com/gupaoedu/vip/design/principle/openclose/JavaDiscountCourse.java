package com.gupaoedu.vip.design.principle.openclose;

public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

//    @Override
//    public Double getPrice() {
//        return super.getPrice();
//    }

    public Double getDiscountPrice() {
        return super.getPrice() * 0.6;
    }
}
