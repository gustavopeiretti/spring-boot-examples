package com.gustavopeiretti.logexample.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4jExampleController {

    // import org.apache.logging.log4j.LogManager;
    // import org.apache.logging.log4j.Logger;
    private static final Logger LOG = LogManager.getLogger(Log4jExampleController.class);

    @GetMapping("/log4j")
    public String logExampleLog4j() {
        LOG.trace("A TRACE Message without going through SLF4J");
        LOG.debug("A DEBUG Message without going through SLF4J");
        LOG.info("An INFO Message without going through SLF4J");
        LOG.warn("A WARN Message without going through SLF4J");
        LOG.error("An ERROR Message without going through SLF4J");
        // FATAL is available in Log4j
        LOG.fatal("A FATAL Message without going through SLF4J");
        return "Hello Log";
    }
}
