package com.gjz.Juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile /CAS/ AtomicInteger/BlockingQueue/线程交互
 */
public class ProducerConsumer_AQS {
    static class MyResource {
        private volatile boolean flag = true;//标志
        private AtomicInteger integer = new AtomicInteger();
        private BlockingQueue<String> blockingQueue;

        public MyResource(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        public void myProduce() throws InterruptedException {
            String data = null;
            boolean result;
            while (flag) {
                data = integer.incrementAndGet() + "";
                result = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
                if (result) {
                    System.out.println(Thread.currentThread().getName() + " 插入队列 \t " + data + " 成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + " 插入队列 \t " + data + " 失败");
                }
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println(Thread.currentThread().getName() + "flag=false 停止活动");

        }

        public void myConsume() throws InterruptedException {
            String result = null;
            while (flag) {

                result = blockingQueue.poll(2L, TimeUnit.SECONDS);

                if (result == null || "".equalsIgnoreCase(result)) {
                    flag = false;
                    System.out.println(Thread.currentThread().getName() + "\t 超过2s没有取到");
                    return;
                }
                    System.out.println(Thread.currentThread().getName() + " 消费 \t " + result);

            }
        }

        public void stop() {
            flag = false;
        }

    }

    public static void main(String[] args) {
        MyResource resource = new MyResource(new ArrayBlockingQueue<>(3));
        new Thread(() -> {
            try {
                resource.myProduce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "myPro").start();
        new Thread(() -> {
            try {
                resource.myConsume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "myCon").start();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        resource.stop();
        System.out.println();
        System.out.println(Thread.currentThread().getName() + "\t 5s时间到 停止");
    }
}
