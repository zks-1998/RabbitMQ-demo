package com.gzhu.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class SpringWorkQueue {
   @RabbitListener(queues = "work.queue")
    public void listenWorkQueueMessage(String msg) throws InterruptedException {
        System.out.println("spring 消费者1接收到消息 ：【" + msg + "】" + LocalTime.now());
        Thread.sleep(20);
    }
    @RabbitListener(queues = "work.queue")
    public void listenWorkQueueMessage2(String msg) throws InterruptedException {
        System.err.println("spring 消费者2接收到消息 ：【" + msg + "】" + LocalTime.now());
        Thread.sleep(200);
    }
}

