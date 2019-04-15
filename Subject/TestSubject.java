package com.My.Test.My.Pattern.Subject;

public class TestSubject {
    public static void main(String[] args) {
        ISubject realSubject=new RealSubject();
        ISubject ProxySubject=new ProxySubject(realSubject);
        ProxySubject.eat();
    }
}
