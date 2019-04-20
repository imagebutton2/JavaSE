package My.JavaSE.Thread;
//创建2个分线程，其中一个线程遍历100以内的偶数，；另一个线程遍历100以内的奇数


//  static void yield()：线程让步
//        暂停当前正在执行的线程，把执行机会让给优先级相同或更高的线程
//        若队列中没有同优先级的线程，忽略此方法
public class TestThreadA  {
    public static void main(String[] args) {
        MyThreadA threadA = new MyThreadA("threadA");

        MyThreadB threadB = new MyThreadB("threadB");

        threadA.start();


        threadB.start();

    }

}

class MyThreadA extends Thread{
    public MyThreadA(String s) {
        super(s);
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
        }
    }
}
class MyThreadB extends Thread{
    public MyThreadB(String s) {
        super(s);
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==1){
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            if(i%20==0){
                yield();
            }
        }
    }
}
