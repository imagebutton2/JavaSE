package Volatile;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author MyData.java---->MyData.class----->JVM字节码
 */
class MyData {

    volatile int number = 0;
    AtomicInteger atomicInteger=new AtomicInteger();

    public void addToNumber() {
        number = 60;
    }

    /**
     * 请注意加了 volatile
     * <p>
     * number++; 3步
     */
    public void addPlusPlus() {
        number++;
    }

    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * @author 1.验证volatile的可见性
 * 1.1 假如 int number =0；number变量之前根本没有添加volatile关键字修饰，没有可见性
 * 1.2 添加volatile，可以解决可见性问题
 * <p>
 * 2.验证volatile不保证原子性
 * 2.1原子性指的是什么意思？
 * 不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割。需要整体完整
 * 要么同时成功，要么同时失败
 * 2.2 volatile不保证原子性
 * 2.3 why?
 * 2.4 怎么解决：
 * 1. synchronized（太大了）
 * 2.用juc下的原子类
 */


public class VolatileDemo {
    /**
     * volatile 可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
     */
    public static void seeOKByVolatile() {

        MyData myData = new MyData();
        new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + "\t come in");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    myData.addToNumber();

                    System.out.println(Thread.currentThread().getName() + "\t updated:" + myData.number);
                }
                , "AAA").start();

        while (myData.number == 0) {
            //  System.out.println(1);
        }
        System.out.println(Thread.currentThread().getName() + "\t miss:" + myData.number);
    }

    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {

            new Thread(() ->
            {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)
            ).start();
        }

        //需要等待上面20个线程全部计算完成后，再用main 线程取得最终的结果值看是多少
        //main gc
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t int,finally number:" + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger ,finally number:" + myData.atomicInteger);
    }
}
