package com.gjz.Juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 一个初始为0的变量，两个线程对其交替操作，一个加一，一个减一。5轮
 * 1.线程 操作 资源类
 * 2.判断  干活  通知
 * 3.防止虚假唤醒
 */
public class ProducerConsumer_Traditional {
    static class ShareData {
        private int number;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void increment() {
            lock.lock();
            try {
                while (number != 0) {
                    condition.await();
                }
                //干活
                number++;
                System.out.println(Thread.currentThread().getName() + " \t " + number);
                //唤醒
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void decrement() {
            lock.lock();
            try {
                while (number == 0) {
                    condition.await();
                }
                //干活
                number--;
                System.out.println(Thread.currentThread().getName() + " \t " + number);
                //唤醒
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ShareData data = new ShareData();

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                data.increment();
            }
        }, "AAA").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                data.decrement();
            }
        }, "BBB").start();
    }
}
