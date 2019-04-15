package com.My.Test.My.Pattern.Subject;

public interface ISubject {
    void eat();

}

class RealSubject implements ISubject {

    @Override
    public void eat() {
        System.out.println("饿了，吃饭");
    }
}

class ProxySubject implements ISubject {
    private ISubject Subject  = null;

    public ProxySubject(ISubject Subject) {
        this.Subject =  Subject;
    }

    @Override
    public void eat() {
        prepare();
        Subject.eat();
        afterEat();
    }

    public void prepare() {
        System.out.println("饭前******");
    }


    public void afterEat() {
        System.out.println("饭后######");
    }
}