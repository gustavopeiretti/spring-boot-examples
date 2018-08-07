package com.gp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RetryTemplateExampleService {

    private static Logger LOGGER = LoggerFactory.getLogger(RetryTemplateExampleService.class);
    private final RetryTemplate retryTemplate;

    @Autowired
    public RetryTemplateExampleService(RetryTemplate retryTemplate) {
        this.retryTemplate = retryTemplate;
    }

    public String retryTemplateExample(String s) {
        String result;
        result = retryTemplate.execute(new RetryCallback<String, RuntimeException>() {
            @Override
            public String doWithRetry(RetryContext retryContext) {
                // do something in this service
                LOGGER.info(String.format("Retry retryTemplateExample %d", LocalDateTime.now().getSecond()));
                if (s == "error") {
                    throw new RuntimeException("Error in ExampleRetryTemplateService.retryTemplateExample ");
                } else {
                    return "Hi " + s;
                }
            }
        });
        LOGGER.info(String.format("Returning %s", result));
        return result;
    }

}
