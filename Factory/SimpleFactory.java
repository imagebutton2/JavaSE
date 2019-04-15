package com.My.Test.My.Pattern.Factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleFactory {
    public static void main(String[] args) {
        IFruit iFruit=FruitSimpleFactory.getInstance(Banana.class.getName());
        iFruit.eat();
    }
}

class Banana implements IFruit{

    @Override
    public void eat() {
        System.out.println("吃香蕉");
    }
}

class FruitSimpleFactory{
    private FruitSimpleFactory(){

    }
    public static IFruit getInstance(String className){
        IFruit iFruit=null;
        try {
            Class aClass=Class.forName(className);
            Constructor constructor=aClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            iFruit=(IFruit) constructor.newInstance();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return iFruit;
    }
}