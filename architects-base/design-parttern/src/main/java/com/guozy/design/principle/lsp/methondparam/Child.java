package com.guozy.design.principle.lsp.methondparam;

import java.util.HashMap;

public class Child extends Base {
//    @Override
//    public void method(HashMap map) {
//        System.out.println("执行子类hashMap入参方法");
//    }
    public void method(HashMap map){
        System.out.println("执行子类map入参方法");
    }
}
