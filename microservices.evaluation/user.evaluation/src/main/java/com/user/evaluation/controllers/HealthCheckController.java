package com.user.evaluation.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/evaluations/health")
public class HealthCheckController {

    @GetMapping
    public String getHealthCheck() {
        return "⋆˙⟡ User Evaluation Accepting Requests ⋆˙⟡";
    }
}
