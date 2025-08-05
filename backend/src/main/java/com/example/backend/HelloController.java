package com.example.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class HelloController {
    private static final Logger logger = LogManager.getLogger(HelloController.class);
    @GetMapping("/api/hello")
    public String hello() {
        logger.debug("[WORKFLOW] Entered hello() in HelloController");
        logger.info("Hello endpoint called");
        return "Hello from Spring Boot backend!";
    }
}
