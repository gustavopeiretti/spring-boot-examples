package com.gustavopeiretti.logexample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogExampleController {

    // import org.slf4j.Logger;
    // import org.slf4j.LoggerFactory;
    private final Logger LOG = LoggerFactory.getLogger(LogExampleController.class);

    @GetMapping("/log")
    public String logExample() {
        LOG.trace("A TRACE Message");
        LOG.debug("A DEBUG Message");
        LOG.info("An INFO Message");
        LOG.warn("A WARN Message");
        LOG.error("An ERROR Message");
        // FATAL is not available in slf4j
        return "Hello Log";
    }

}
