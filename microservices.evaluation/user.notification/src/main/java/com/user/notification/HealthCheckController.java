package com.user.notification;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications/health")
public class HealthCheckController {

    @GetMapping
    public String getHealthCheck() {
        return "⋆˙⟡ User Notification Accepting Requests ⋆˙⟡";
    }
}
