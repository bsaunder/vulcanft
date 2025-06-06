package com.btsaunde.vulcanft.svgservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple controller used as a health check endpoint for the service.
 */
@RestController
public class HomeController {

    /**
     * Basic home endpoint which returns a JSON structure indicating that the
     * service is running.
     *
     * @return map containing a single <code>status</code> field
     */
    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "ok");
        return response;
    }
}
