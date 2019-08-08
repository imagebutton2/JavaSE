package com.gjz.Juc.ProducerAndConsumer;

import java.util.concurrent.TimeUnit;

public class Goods {
    private String name;
    private volatile int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    public synchronized void set(String name) throws InterruptedException {
        while (this.count > 0) {
            System.out.println("库存已满 ：等待消费者");
            wait();
        }
        this.name = name;
        this.count++;
        TimeUnit.MILLISECONDS.sleep(2000);
        System.out.println(Thread.currentThread().getName() + "  生产 \t  " + toString());
        notifyAll();
    }

    public synchronized void get() throws InterruptedException {
        while (this.count == 0) {
            System.out.println("库存为0 ：请求生产");
            wait();
        }
        this.count--;
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println(Thread.currentThread().getName() + "   消费 \t  " + toString());
        notifyAll();
    }

}
