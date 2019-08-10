package com.gjz.Juc;

import java.util.concurrent.*;

public class CountDownLatchDemo {
    static enum MyCache {
        ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");
        private Integer retCode;
        private String retMessage;

        public Integer getRetCode() {
            return retCode;
        }

        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        public String getRetMessage() {
            return retMessage;
        }

        public void setRetMessage(String retMessage) {
            this.retMessage = retMessage;
        }

        MyCache(Integer retCode, String retMessage) {
            this.retCode = retCode;
            this.retMessage = retMessage;
        }

        public static MyCache forEachMyCache(int index) {
            MyCache[] myCaches = MyCache.values();
            for (MyCache cache : myCaches) {
                if (cache.getRetCode() == index) {
                    return cache;
                }
            }
            return null;
        }
    }


    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + " 上完自习离开教室");
                countDownLatch.countDown();
            }
                    , MyCache.forEachMyCache(i).retMessage).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t" + "******* 班长锁门走人****");
    }
}
