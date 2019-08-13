package com.gjz.Juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
//        try {
//            blockingQueue.put("a");
//            blockingQueue.put("b");
//            blockingQueue.put("c");
//            System.out.println(blockingQueue.take());
//            System.out.println(blockingQueue.take());
//            System.out.println(blockingQueue.take());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            blockingQueue.offer("a",2L,TimeUnit.MILLISECONDS);
            blockingQueue.offer("b",2L,TimeUnit.MILLISECONDS);
            blockingQueue.offer("c",2L,TimeUnit.MILLISECONDS);
            blockingQueue.offer("d",2000L,TimeUnit.MILLISECONDS);
            TimeUnit.MILLISECONDS.sleep(1);
            System.out.println(blockingQueue);
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
