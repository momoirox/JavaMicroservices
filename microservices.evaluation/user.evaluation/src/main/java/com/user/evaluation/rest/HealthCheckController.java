package com.user.evaluation.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/evaluations/health")
public class HealthCheckController {

    @GetMapping
    public String getHealthCheck() {
        return "⋆˙⟡ User Evaluation Accepting Requests ⋆˙⟡";
    }
}
