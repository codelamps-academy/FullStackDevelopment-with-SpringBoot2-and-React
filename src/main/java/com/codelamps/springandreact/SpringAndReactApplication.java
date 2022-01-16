package com.codelamps.springandreact;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringAndReactApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringAndReactApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringAndReactApplication.class, args);

        logger.info("Hello Spring Boot");
        log.info("Hello Andre Rizaldi Brillianto");
    }

}
