package com.gustavopeiretti.springbootbean;

import com.gustavopeiretti.springbootbean.config.SenderMessages;
import com.gustavopeiretti.springbootbean.service.AppService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBeanApplication {

    private final AppService appService;

    private final SenderMessages senderMessages;

    public SpringBootBeanApplication(AppService appService, SenderMessages senderMessages) {
        this.appService = appService;
        this.senderMessages = senderMessages;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBeanApplication.class, args);
    }

    @PostConstruct
    public void doExamples() {
        System.out.println("Calling bean method with this result: " +  appService.calculate(123));

        System.out.println("Calling SenderMessages: ");
        senderMessages.send("hello universe");
    }
}
