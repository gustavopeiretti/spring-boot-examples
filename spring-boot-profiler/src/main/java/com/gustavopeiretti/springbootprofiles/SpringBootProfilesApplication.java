package com.gustavopeiretti.springbootprofiles;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProfilesApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootProfilesApplication.class);

    @Value("${data.by.environment}")  // our property for the active profile
    private String dataByEnvironment;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProfilesApplication.class, args);
    }

    @PostConstruct
    public void doSomething() {
        logger.info("Property data.by.environment value is {}", dataByEnvironment);
    }

}
