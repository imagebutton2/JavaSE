package My.JavaSE.Thread;
//创建多线程2：
//实现Runnable接口
//实现Runnable的抽象方法：run
//创建实现类的对象
//传递Thread
//.start
public class TestThreadD {
    public static void main(String[] args) {
        Runnable runnable=new Mythread();
        Thread thread=new Thread(runnable,"runnable");

        thread.start();
        Runnable runnable1=new Mythread();
        Thread thread1=new Thread(runnable1,"runnable1");
        thread1.start();
    }

}
class Mythread implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
        }
    }
}