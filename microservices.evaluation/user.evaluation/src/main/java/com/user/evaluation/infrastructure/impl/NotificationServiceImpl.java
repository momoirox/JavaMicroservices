package com.user.evaluation.infrastructure.impl;

import com.user.evaluation.infrastructure.model.EvaluationCreatedEvent;
import com.user.evaluation.infrastructure.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final KafkaTemplate<String, EvaluationCreatedEvent> kafkaTemplate;

    @Override
    public void notify(String email) {
        EvaluationCreatedEvent event = new EvaluationCreatedEvent(email);
        publish(event);
    }

    @Override
    public void notify(String email, String message) {
        EvaluationCreatedEvent event = new EvaluationCreatedEvent(email, message);
        publish(event);
    }

    private void publish(EvaluationCreatedEvent event) {
        log.info("Start - Send to topic ... ");
        kafkaTemplate.send("evaluation-created", event);
        log.info("End - Send to topic ... ");
    }
}
