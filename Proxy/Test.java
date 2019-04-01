package cn.bitten.java.Reflex.My;

public class Test{
    public static void main(String[] args) {
        ISubject subject=new RealSubject();
        ISubject subject1=new ProxySubject(subject);
        subject1.eat();
    }
}
