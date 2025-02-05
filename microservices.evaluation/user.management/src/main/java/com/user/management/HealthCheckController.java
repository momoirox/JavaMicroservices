package com.user.management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/managements/health")
public class HealthCheckController {

    @GetMapping
    public String getHealthCheck() {
        return "⋆˙⟡ User Management Accepting Requests ⋆˙⟡";
    }
}
