package com.gjz.Juc.ProducerAndConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {
    public static void main(String[] args) {
        Goods good = new Goods();

        List<Thread> list = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Thread thread = new Thread(new Producer(good));
            thread.setName("生产者 " + i);
            list.add(thread);
        }
        for (int i = 1; i <= 10; i++) {
            Thread thread = new Thread(new Consumer(good));
            thread.setName("消费者 " + i);
            list.add(thread);
        }
        for (Thread t : list) {
            t.start();
        }
    }
}
