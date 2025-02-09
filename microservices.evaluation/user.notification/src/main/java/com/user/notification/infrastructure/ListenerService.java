package com.user.notification.infrastructure;

import com.user.notification.core.EmailSenderService;
import com.user.notification.infrastructure.model.EvaluationCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ListenerService {
    private final EmailSenderService emailSenderService;

    @KafkaListener(topics = "evaluation-created")
    public void listen(EvaluationCreatedEvent event) {
        log.info("Consuming message... {}", event);
        String emailContent = event.getContent();
        String emailTo = event.getEmailTo();
        emailSenderService.send(emailTo, emailContent);
    }

}
