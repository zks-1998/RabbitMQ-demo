package com.gzhu.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    //声明交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("gzhu.fanout");
    }
    //队列1
    @Bean
    public Queue fanouQueue1(){
        return new Queue("fanout.queue1");
    }
    //绑定关系1
        @Bean
        public Binding fanoutBinding1(Queue fanouQueue1, FanoutExchange fanoutExchange){
            return BindingBuilder
                    .bind(fanouQueue1)
                    .to(fanoutExchange);
    }
    //队列2
    @Bean
    public Queue fanouQueue2(){
        return new Queue("fanout.queue2");
    }
    //绑定关系2
    @Bean
    public Binding fanoutBinding2(Queue fanouQueue2, FanoutExchange fanoutExchange){
        return BindingBuilder
                .bind(fanouQueue2)
                .to(fanoutExchange);
    }

    @Bean
    public Queue objectMessageQueue(){
        return new Queue("object.queue");
    }

}
