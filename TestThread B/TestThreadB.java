//创建3个窗口卖票
//线程存在不安全

public class TestThreadB {
    public static void main(String[] args) {
        Window window1=new Window();
        Window window2=new Window();
        Window window3=new Window();
        window1.start();
        window2.start();
        window3.start();
    }
}
class Window extends Thread{
    private static int ticket=100;

    @Override
    public void run() {
        while (this.ticket>0){
                if(ticket>0){
                    System.out.println(getName()+": 买票，票号为："+ticket--);
                }
        }
        System.out.println("票买完了");
    }
}