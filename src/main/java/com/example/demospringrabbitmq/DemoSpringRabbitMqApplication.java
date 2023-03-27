package com.example.demospringrabbitmq;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringRabbitMqApplication {
    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringRabbitMqApplication.class);
    }
}
