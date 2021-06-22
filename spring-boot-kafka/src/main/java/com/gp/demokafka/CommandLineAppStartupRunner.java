package com.gp.demokafka;

import com.gp.demokafka.producer.KafkaProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final KafkaProducer producer;

    public CommandLineAppStartupRunner(KafkaProducer producer) {
        this.producer = producer;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            producer.sendMessage("Hello kafka !! " + i);
            Thread.sleep(2000);
        }
    }
}
