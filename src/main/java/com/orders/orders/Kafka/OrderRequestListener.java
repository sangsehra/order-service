package com.orders.orders.Kafka;

import com.entities.common.common_entities.Records;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class OrderRequestListener {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public OrderRequestListener(
            KafkaTemplate<String, String> kafkaTemplate,
            ObjectMapper objectMapper
    ) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(
            topics = "order-request-topic",
            groupId = "orders-service"
    )
    public void handle(String message) throws Exception {

        Records.OrderRequestEvent request =
                objectMapper.readValue(message, Records.OrderRequestEvent.class);

        // fetch orders (mock example)
        List<String> orders = List.of("order-1", "order-2");

        Records.OrderResponseEvent response =
                new Records.OrderResponseEvent(request.requestId(), orders);

        kafkaTemplate.send(
                "order-response-topic",
                request.requestId(),
                objectMapper.writeValueAsString(response)
        );
    }


}

