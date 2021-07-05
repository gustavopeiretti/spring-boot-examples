package com.gp.demokafka.consumer;

import com.gp.demokafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaJsonConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaJsonConsumer.class);

    @KafkaListener(topics = "TOPIC-DEMO-JSON", groupId = "group_id")
    public void consume(User message) {
        logger.info("Consuming Message {}", message);
    }

}
