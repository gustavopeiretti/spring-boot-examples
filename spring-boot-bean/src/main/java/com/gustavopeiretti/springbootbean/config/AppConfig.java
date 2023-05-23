package com.gustavopeiretti.springbootbean.config;

import com.gustavopeiretti.springbootbean.service.MultiplierService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = {"multiplierService",
            "multiplierService-alias1", "multiplierService-alias2"},
            initMethod = "init", destroyMethod = "destroy")
    public MultiplierService multiplier() {
        return new MultiplierService(2);
    }


    @ConditionalOnProperty(name = "sender.sms", havingValue = "true", matchIfMissing = true)
    @Bean(name = "senderMessagesSms")
    public SenderMessages senderMessagesSms() {
        return new SenderMessagesSms();
    }

    @ConditionalOnProperty(name = "sender.sms", havingValue = "false")
    @Bean(name = "senderMessagesEmail")
    public SenderMessages senderMessagesEmail() {
        return new SenderMessagesEmail();
    }

}
