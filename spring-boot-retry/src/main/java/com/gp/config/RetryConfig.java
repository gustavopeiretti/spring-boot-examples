package com.gp.config;

import com.gp.exception.ApiRetryException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class RetryConfig {

    @Bean
    public RetryTemplate retryTemplate() {

        return RetryTemplate.builder()
                .maxAttempts(4)
                .fixedBackoff(1000L)
                .retryOn(ApiRetryException.class)
                .withListener(new ApiRetryListener())
                .build();
    }

}
