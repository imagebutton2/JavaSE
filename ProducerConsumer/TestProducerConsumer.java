package My.Test.ProducerConsumer;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.Scanner;

public class TestProducerConsumer {
    
   
    
    public static void main(String[] args) {
        
        /*
        
        问题：
        1. 容量
        2. 生产者消费者线程
        3. 生产和消费速率
        
        如何动态修改参数：
        1. 命令行参数  args[]
        2. 通过控制台的接收用户键盘输入
        3. 通过外部配置文件读取
        4. 数据库，内存服务器（redis），目录服务(zookeeper)
        
        重构：
        1. ProducerConsumerManager类进行生产者和消费者的创建，初始化，启动
        2. 停止？   标记位的方式
        
        */
        //商品容器
        final Queue<Goods> queue = new LinkedList<>();
        final Integer maxGoods = 10;

        //生产者
        final Producer producer = new Producer(queue, maxGoods, 2000L);
        //消费者
        final Consumer consumer = new Consumer(queue, 1500L);

        //线程
//        Thread producerThread1 = new Thread(producer, "生产者-1");
//        Thread consumerThread1 = new Thread(consumer,
//                "消费者-1");
//        producerThread1.start();
//        consumerThread1.start();

        /*
        1. 生产者和消费者 单线程 并且无时间间隔
        2. 模拟现实  速率问题
        3. 多线程版本
         */
        for (int i = 0; i < 5; i++) {
            new Thread(producer, "Thread-producer-" + i).start();
        }

        for (int i = 0; i < 8; i++) {
            new Thread(consumer, "Thread-consumer-" + i).start();
        }

    }
    
    
}
