package com.My.Test.My.Pattern.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface  Human{
    String getBelief();

    void eat(String food);
}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe i can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃 "+food);
    }
}
//要想实现动态代理，需要解决的问题？
//问题1：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
//问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法


class ProxyFactory{
    //调用此方法。返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){
        InvocationHandler handler=new MyInvocationHandler(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}
class MyInvocationHandler implements InvocationHandler {
    private final   Object obj;//被代理对象

    MyInvocationHandler(Object obj) {
        this.obj = obj;
    }


//当我们通过代理类的对象，调用方法a时，就会自动的
    //调用，如下方法 invoke

    //method :即为代理类对象调用的方法，此方法也就作为了被代理类对象的方法
    //obj 被代理对象
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object returnValue=method.invoke(obj,args);

        return returnValue;
    }
}
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan=new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief=proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

    }
}
