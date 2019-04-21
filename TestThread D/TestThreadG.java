package My.JavaSE.Thread;
/**
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 * 例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 *
 */

public class TestThreadG {
    public static void main(String[] args) {
        WindowA window1=new WindowA("WindowA");
        WindowA window2=new WindowA("WindowB");
        WindowA window3=new WindowA("WindowC");
        window1.start();
        window2.start();
        window3.start();

    }

}

//卖票--->共享数据

class WindowA extends Thread{

    private  static int ticket=20;

    public WindowA(String s) {
        super(s);
    }

    @Override
    public void run() {

        while (this.ticket>0) {
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.getClass()) {
                //错误的方式：this代表着t1,t2,t3三个对象
//              synchronized (this){
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "\t" + ticket--);
                    if (ticket == 0) {
                        System.out.println("卖完了");
                    }
                }
            }
        }
    }
}
