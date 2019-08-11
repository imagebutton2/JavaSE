package com.gjz.Juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {

    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " " + "come in");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
    }

    public void myunLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " " + "go away");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) {
        SpinLockDemo lockDemo = new SpinLockDemo();
        new Thread(() -> {
            lockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockDemo.myunLock();
        }, "AAAA").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            lockDemo.myLock();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockDemo.myunLock();
        }, "BBBB").start();

    }
}
