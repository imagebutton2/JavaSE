package cn.bitten.java.Reflex.My;

public class Test {
    public static void main(String[] args) {
        ISubject subject = Factory.getInstance("cn.bitten.java.Reflex.My.ProxySubject", Factory.getInstance("cn.bitten.java.Reflex.My.RealSubject"));
        subject.eat();
       
    }
}
