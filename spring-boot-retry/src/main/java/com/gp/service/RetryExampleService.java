package com.gp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RetryExampleService {

    private static Logger LOGGER = LoggerFactory.getLogger(RetryExampleService.class);

    @Retryable(value = {RuntimeException.class}, maxAttempts = 4, backoff = @Backoff(1000))
    public String retryExample(String s) {
        LOGGER.info(String.format("Retry retryTemplateExample %d", LocalDateTime.now().getSecond()));
        if (s == "error") {
            throw new RuntimeException("Error in RetryExampleService.retryExample ");
        } else {
            return "Hi " + s;
        }
    }

    @Recover
    public String retryExampleRecovery(RuntimeException t, String s) {
        LOGGER.info(String.format("Retry Recovery - %s", t.getMessage()));
        return "Retry Recovery OK!";
    }
}
