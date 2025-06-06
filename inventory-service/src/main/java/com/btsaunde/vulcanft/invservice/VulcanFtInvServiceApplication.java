package com.btsaunde.vulcanft.invservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Inventory Service Spring Boot application.
 */
@SpringBootApplication
public class VulcanFtInvServiceApplication {

        /**
         * Bootstraps the application.
         *
         * @param args standard command line arguments
         */
        public static void main(String[] args) {
                SpringApplication.run(VulcanFtInvServiceApplication.class, args);
        }

}
