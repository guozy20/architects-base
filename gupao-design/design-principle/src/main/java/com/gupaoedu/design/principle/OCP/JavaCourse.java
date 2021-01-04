package com.gupaoedu.design.principle.OCP;

/**
 * @ProjectName gupao-design
 * @Classname JavaCourse
 * @Description TODO
 * @Date 2021/1/4 11:36
 * @Created by guoziyang
 */
public class JavaCourse implements ICourse {
    private Integer id;
    private String name;
    private Double price;

    public JavaCourse(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
