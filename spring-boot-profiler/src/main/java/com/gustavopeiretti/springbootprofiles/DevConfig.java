package com.gustavopeiretti.springbootprofiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    private static final Logger logger = LoggerFactory.getLogger(DevConfig.class);

    @Bean
    public void configOnlyForDev() {
        logger.info("This config is only for DEV");
    }

}
