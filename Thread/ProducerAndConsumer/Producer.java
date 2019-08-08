package com.gjz.Juc.ProducerAndConsumer;

public class Producer implements Runnable {
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.goods.set("奔驰一辆");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
