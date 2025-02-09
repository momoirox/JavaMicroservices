package com.user.evaluation.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EvaluationCreatedEvent {
    private static final String DEFAULT_MESSAGE = "Your evaluation has been created. " +
            "Please login to see more details.";
    private String content;
    private String emailTo;

    public EvaluationCreatedEvent(String emailTo) {
        this.content = DEFAULT_MESSAGE;
        this.emailTo = emailTo;
    }
}
