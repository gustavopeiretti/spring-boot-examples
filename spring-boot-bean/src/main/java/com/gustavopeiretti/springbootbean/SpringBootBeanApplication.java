package com.gustavopeiretti.springbootbean;

import com.gustavopeiretti.springbootbean.service.AppService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBeanApplication {

    @Autowired
    private AppService appService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBeanApplication.class, args);
    }

    @PostConstruct
    public void doExamples() {
        System.out.println("Calling bean method with this result: " +  appService.calculate(123));
    }

}
