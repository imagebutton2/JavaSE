package My.JavaSE.Thread;
//创建一个守护线程
public class TestThreadL {
    public static void main(String[] args) {
        System.out.println("main执行....");

       Thread thread= new Thread(new Runnable() {
            int i=0;
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "\t" + "running" + "\t" + (i++));
                }
            }
        },"守护线程");
       thread.setDaemon(true);
       thread.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main.....");
        System.out.println("main完了");
    }
}
