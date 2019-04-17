package com.bittech.annotation;

import java.lang.annotation.Annotation;

/**
 * 注解的作用范围： Source Class Runtime
 * 通过Class对象获取注解，策略 Runtime
 * <p>
 * <p>
 * Author: secondriver
 * Created: 2019/3/31
 */
@Deprecated
@SuppressWarnings(value = {"unused"})
public class TestAnnotation {
    
    
    @Override
    @Deprecated
    public String toString() {
        return super.toString();
    }
    
    public static void main(String[] args) {
        Class classz = TestAnnotation.class;
        try {
            Annotation annotation =classz.getMethod("toString").getAnnotation(Deprecated.class);
            System.out.println(annotation.annotationType()+ " "+annotation.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    
    }
}
