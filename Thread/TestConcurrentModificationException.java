package com.gjz.List;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestConcurrentModificationException {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("a");

        for(int i=1;i<=10;i++){
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(()->
            {

                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getId()+" "+list);
                System.out.println("======================");
            },UUID.randomUUID().toString().substring(0,1)).start();

        }
    }
}
