package My.JavaSE.Thread;
// jdk5.0提供2种方法Callable
//方法一：
//  //1.创建一个实现Callable的实现类
////2.实现call方法，将此线程需要执行的操作声明在call()中
//    //3.创建Callable接口实现类的对象
////4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
////5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
//          //6.获取Callable中call方法的返回值
//            //get()返回值即为FutureTask构造器参数Callable实现类重写的call()的返回值。
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class TestThreadK {

    public static void main(String[] args) {
        Callable<String> callable=new MyTickCallable();
        FutureTask<String>stringFutureTask=new FutureTask<>(callable);

        Thread thread1=new Thread(stringFutureTask,"窗口一");
        thread1.start();
        try {
            thread1.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class MyTickCallable implements Callable<String> {

    private int tick = 20;

    @Override
    public String call() throws Exception {
        while (this.tick > 0) {
            Thread.sleep(200);
            synchronized (this) {
                if(this.tick>0){

                System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + (--this.tick));
                if(this.tick==0){
                    System.out.println("票卖完了。。。");
                }
                }
            }
        }
        return "票卖完了。。。";
    }
}