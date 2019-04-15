package com.My.Test.My.Pattern.Subject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FactorySubject {
    public static void main(String[] args) {

     ISubject iSubject=Factory.getInstance(ProxySubject.class.getName(),Factory.getInstance(RealSubject.class.getName()));
     iSubject.eat();
    }

}

class Factory {
    private Factory() {

    }

    //一个类的创建
    public static <T> T getInstance(String className) {
        T t = null;
        try {
            t = (T) Class.forName(className).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static <T> T getInstance(String className, Object obj) {
            T t=null;

        try {
            Class aClass=Class.forName(className);


            Constructor constructor=aClass.getConstructor(obj.getClass().getInterfaces()[0]);
            t=(T)constructor.newInstance(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return t;
    }
}