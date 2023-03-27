package com.example.demospringrabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;

public class StandAloneApp {
    @SneakyThrows
    public static void main(String[] args) {
        var connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        var connection = connectionFactory.newConnection();
        var channel = connection.createChannel();
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            var messageStr = new String(message.getBody(), StandardCharsets.UTF_8);
            System.out.println(messageStr);
        };
        channel.basicConsume("external-java-queue", true, deliverCallback, consumerTag -> {});
    }
}
