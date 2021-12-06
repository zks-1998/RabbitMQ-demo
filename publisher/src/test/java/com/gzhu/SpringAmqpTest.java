package com.gzhu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    public void testSimpleQueue() {
        String queueName = "simple.queue";
        String message = "hello, spring amqp!";
        rabbitTemplate.convertAndSend(queueName, message);
    }
    @Test
    public void testWorkQueue() throws InterruptedException {
        String queueName = "work.queue";
        String message = "hello, I am _";
        for (int i = 0; i < 50; i++) {
            rabbitTemplate.convertAndSend(queueName, message+ i);
            Thread.sleep(20);
        }
    }

    @Test
    public void testSendFanoutExchange(){
        //交换机名称写死
        String exchangeName = "gzhu.fanout";
        //消息
        String message = "hello, baby!!";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }

    @Test
    public void testDirectExchange() {
        // 队列名称
        String exchangeName = "gzhu.direct";
        // 消息
        String message = "红色警报！日本乱排核废水，导致海洋生物变异，惊现哥斯拉！";
        // 发送消息，参数依次为：交换机名称，RoutingKey，消息
        rabbitTemplate.convertAndSend(exchangeName, "red", message);
    }

    @Test
    public void testTopicExchange() {
        // 队列名称
        String exchangeName = "gzhu.topic";
        // 消息
        String message = "祖国统一，收复台湾 ！";
        // 发送消息，参数依次为：交换机名称，RoutingKey，消息
        rabbitTemplate.convertAndSend(exchangeName, "china.song", message);
    }

    @Test
    public void testSendMap() throws InterruptedException {
        // 准备消息
        Map<String,Object> msg = new HashMap<>();
        msg.put("name", "Jack");
        msg.put("age", 21);
        // 发送消息
        rabbitTemplate.convertAndSend("object.queue", msg);
    }

}

