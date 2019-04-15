package com.My.Test.My.Pattern.Factory;

public class TestFactory {
    public static void main(String[] args) {
        IFruit iFruit=FruitFactory.getInstance("Apple");
        iFruit.eat();
        System.out.println("------------");
        IFruit iFruit1=FruitFactory.getInstance("Orange");
        iFruit1.eat();
    }

}

interface IFruit{
    void  eat();
}

class Apple implements IFruit{

    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}
class  Orange implements IFruit{

    @Override
    public void eat() {
        System.out.println("吃橘子");
    }
}

class FruitFactory{
    private FruitFactory(){

    }
    public static IFruit getInstance(String className){
        if ("Apple".equals(className)){
          return   new Apple();
        } else if("Orange".equals(className)){
          return   new Orange();
        }else {
            return null;
        }
    }
}