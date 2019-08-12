package com.gjz.Juc;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.*;

public class CallableDemo {
    static class MyThread implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println(Thread.currentThread().getName() + " \t come in");
            TimeUnit.SECONDS.sleep(2);
            return 1024;
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        FutureTask<Integer> task = new FutureTask<>(new MyThread());
        service.submit(task);
//        FutureTask<Integer> task = new FutureTask<>(new MyThread());
//        new Thread(task, "aaa").start();
//        new Thread(task, "bbb").start();
        int i = 100;
        int result = 0;
        try {
            result = i + task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " \t " + result);
        service.shutdown();
    }
}
