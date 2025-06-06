package com.btsaunde.vulcanft.svgservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the SVG generation service. This class simply boots the
 * Spring application.
 */
@SpringBootApplication
public class VulcanFtSvgServiceApplication {

        /**
         * Launches the Spring Boot application.
         *
         * @param args application arguments passed on the command line
         */
        public static void main(String[] args) {
                SpringApplication.run(VulcanFtSvgServiceApplication.class, args);
        }

}
