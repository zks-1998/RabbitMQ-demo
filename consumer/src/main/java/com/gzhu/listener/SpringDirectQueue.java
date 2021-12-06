package com.gzhu.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class SpringDirectQueue {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "gzhu.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}))
    public void listenDirectQueue1(String msg){
        System.out.println("消费者1接收到Direct消息：【"+msg+"】");}

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "gzhu.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}))public void listenDirectQueue2(String msg){
        System.out.println("消费者2接收到Direct消息：【"+msg+"】 ");
    }
}

