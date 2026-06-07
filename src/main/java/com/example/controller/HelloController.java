package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/health")
    public String health() {
        return "{\"status\": \"UP\", \"message\": \"Application is healthy\"}";
    }

    @GetMapping("/api/hello/{name}")
    public String hello(@PathVariable String name) {
        return "{\"message\": \"Hello, " + name + "! Welcome to Jenkins-Nexus CI/CD Pipeline\"}";
    }

    @GetMapping("/api/version")
    public String version() {
        return "{\"version\": \"1.0.0\", \"buildTime\": \"" + System.currentTimeMillis() + "\"}";
    }
}
