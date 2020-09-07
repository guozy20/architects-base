package com.guozy.thread.example.springbootthreaddemo;

public class Test {
    public static void main(String[] args) {
        String str = "d<span>ff<span>dsg<div>fd</div>fg<p>df</p >gd<label>f</label>";
        str = str.replaceAll("(?<=>)([^<]+)(?=<)", "*");
        System.out.println(str);
        str = str.replaceAll("([^<>]+)(<.*>)([^<>]+)", "*$2*");
        System.out.println(str);
    }
}
