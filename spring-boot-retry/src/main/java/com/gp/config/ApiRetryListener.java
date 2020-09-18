package com.gp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

public class ApiRetryListener extends RetryListenerSupport {

    private static Logger LOGGER = LoggerFactory.getLogger(ApiRetryListener.class);

    @Override
    public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
        LOGGER.info("ApiRetryListener.open");
        return super.open(context, callback);
    }

    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        LOGGER.info("ApiRetryListener.onError");
    }

    @Override
    public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        LOGGER.info("ApiRetryListener.close");
        LOGGER.info("ApiRetryListener.onError isExhausted {}", isExhausted(context));
    }


    private boolean isExhausted(RetryContext context) {
        return context.hasAttribute(RetryContext.EXHAUSTED);
    }

    private boolean isClosed(RetryContext context) {
        return context.hasAttribute(RetryContext.CLOSED);
    }

    private boolean isRecovered(RetryContext context) {
        return context.hasAttribute(RetryContext.RECOVERED);
    }

}
