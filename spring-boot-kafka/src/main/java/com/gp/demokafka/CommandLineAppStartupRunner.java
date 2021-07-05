package com.gp.demokafka;

import com.gp.demokafka.model.User;
import com.gp.demokafka.producer.KafkaStringProducer;
import com.gp.demokafka.producer.KafkaJsonProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final KafkaStringProducer stringProducer;
    private final KafkaJsonProducer jsonProducer;

    public CommandLineAppStartupRunner(KafkaStringProducer stringProducer, KafkaJsonProducer jsonProducer) {
        this.stringProducer = stringProducer;
        this.jsonProducer = jsonProducer;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            stringProducer.sendMessage("Hello kafka !! " + i);
            Thread.sleep(2000);
        }
        jsonProducer.sendMessage(new User("Larry"));
        jsonProducer.sendMessage(new User("The Edge"));
        jsonProducer.sendMessage(new User("Charly"));
    }
}
