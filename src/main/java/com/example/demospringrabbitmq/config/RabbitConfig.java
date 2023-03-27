package com.example.demospringrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitConfig {
    @Bean
    public Binding springQueueBinding() {
        return BindingBuilder.bind(localSpringQueue())
                .to(messageExchangeDirect())
                .with("my-key")
                .noargs();
    }

    @Bean
    public Queue localSpringQueue() {
        return new Queue("spring-queue");
    }

    @Bean
    public Exchange messageExchangeDirect() {
        return new DirectExchange("message-direct");
    }
}
