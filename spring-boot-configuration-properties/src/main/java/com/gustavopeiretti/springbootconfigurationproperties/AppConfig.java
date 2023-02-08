package com.gustavopeiretti.springbootconfigurationproperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties(prefix = "app.mail")
    public MailData mailData() {
        MailData mailData = new MailData();
        return mailData;
    }

}
