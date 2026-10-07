package com.ninjabank.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping({"/health", "/auth/health"})
    public String health() {
        return "User Service is healthy";
    }
}
