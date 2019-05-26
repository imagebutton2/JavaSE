package com.lanqiao.Mian;

/**
 * 父类静态变量
 * 父类静态代码块（若有多个按代码先后顺序执行）
 * 子类静态变量
 * 子类静态代码块（若有多个按代码先后顺序执行）
 * 父类非静态变量
 * 父类非静态代码块（若有多个按代码先后顺序执行）
 * 父类构造函数
 * 子类非静态变量
 * 子类非静态代码块（若有多个按代码先后顺序执行）
 * 子类构造函数
 * 所有的静态资源都只会加载一次，非静态资源可以重复加载。
 */
public class Main3 {



    public static void main(String[] args) {

        System.out.print(B.c);

    }

}



class A {

    public static String c = "C";

    static {

        System.out.print("A");

    }

}



class B extends A{

    static {

        System.out.print("B");

    }
}