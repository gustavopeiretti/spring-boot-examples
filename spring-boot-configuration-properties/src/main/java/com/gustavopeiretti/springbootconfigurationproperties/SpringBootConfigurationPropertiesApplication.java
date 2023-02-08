package com.gustavopeiretti.springbootconfigurationproperties;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConfigurationPropertiesApplication {

    @Autowired
    AppInfo appInfo;

    @Autowired
    MailData mailData;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigurationPropertiesApplication.class, args);
    }

    @PostConstruct
    public void post() {
        System.out.println();
        System.out.println(appInfo);
        System.out.println(mailData);
    }
}
