package My.JavaSE.Thread;
//创建 3个窗口卖票(第二种方式)
//线程存在不安全
public class TestThreadE {
    public static void main(String[] args) {

        Window1 runnable=new Window1();
        Thread thread=new Thread(runnable,"窗口A");
        Thread thread1=new Thread(runnable,"窗口B");
        Thread thread2=new Thread(runnable,"窗口C");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
class Window1 implements Runnable {
    private static int ticket = 100;

    @Override
    public void run() {
        while (this.ticket > 0) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 买票，票号为：" + ticket--);
            }
        }
        if (ticket==0){
            System.out.println("票买完了");
        }

    }
}