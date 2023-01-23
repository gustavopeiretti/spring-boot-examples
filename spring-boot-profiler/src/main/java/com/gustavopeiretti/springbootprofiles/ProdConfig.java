package com.gustavopeiretti.springbootprofiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfig {

    private static final Logger logger = LoggerFactory.getLogger(ProdConfig.class);

    @Bean
    public void configOnlyForProd() {
        logger.info("This config is only for PROD");
    }

}
