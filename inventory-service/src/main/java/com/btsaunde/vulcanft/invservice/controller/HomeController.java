package com.btsaunde.vulcanft.invservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple controller exposing a basic health endpoint for the service.
 */
@RestController
public class HomeController {

    /**
     * Returns a simple JSON map indicating the service is running.
     *
     * @return map containing {@code status} and {@code service} keys
     */
    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "ok");
        response.put("service","inventory");
        return response;
    }
}
