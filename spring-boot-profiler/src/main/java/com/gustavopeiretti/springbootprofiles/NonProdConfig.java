package com.gustavopeiretti.springbootprofiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!dev")
public class NonProdConfig {

    private static final Logger logger = LoggerFactory.getLogger(NonProdConfig.class);

    @Bean
    public void configOnlyForNonDev() {
        logger.info("This config is for NON DEV profiles");
    }

}
