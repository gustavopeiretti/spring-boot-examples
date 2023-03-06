package com.gustavopeiretti.springbootbean.config;

import com.gustavopeiretti.springbootbean.service.MultiplierService;
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

}
