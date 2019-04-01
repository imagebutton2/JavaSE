package cn.bitten.java.Reflex.My;

public class RealSubject implements ISubject{
    @Override
    public void eat() {
        System.out.println("饿了要吃饭");
    }
}
