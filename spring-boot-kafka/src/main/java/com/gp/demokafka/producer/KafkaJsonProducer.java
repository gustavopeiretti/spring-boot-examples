package com.gp.demokafka.producer;

import com.gp.demokafka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);

    private final KafkaTemplate<String, User> kafkaTemplate;

    public KafkaJsonProducer(@Qualifier("kafkaJsonTemplate") KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {
        LOGGER.info("Producing message {}", user);
        this.kafkaTemplate.send("TOPIC-DEMO-JSON", user);
    }

}
