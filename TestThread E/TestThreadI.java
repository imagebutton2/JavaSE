package My.JavaSE.Thread;
/**
 * 使用同步方法处理继承Thread类的方式中的线程安全问题
 *

 */
public class TestThreadI {
    public static void main(String[] args) {
        Window3 t1 = new Window3();
        Window3 t2 = new Window3();
        Window3 t3 = new Window3();


        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}

class Window3 extends Thread {


    private static int ticket = 100;

    @Override
    public void run() {

        while (true) {

            show();
        }

    }
    private static synchronized void show(){//同步监视器：Window4.class
        //private synchronized void show(){ //同步监视器：t1,t2,t3。此种解决方式是错误的
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }
    }
}