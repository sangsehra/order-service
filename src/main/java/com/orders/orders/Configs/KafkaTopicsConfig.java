package com.orders.orders.Configs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicsConfig {
    @Bean
    public NewTopic orderResponseTopic() {
        return new NewTopic("order-response-topic", 1, (short) 1);
    }
}
