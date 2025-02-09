package com.user.notification.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EvaluationCreatedEvent {
    private String content;
    private String emailTo;
}
