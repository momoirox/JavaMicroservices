package com.user.notification.core.impl;

import com.user.notification.core.EmailSenderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {
    private static final String EMAIL_SUBJECT = "Evaluation created";
    private static final String EMAIL_SENDER = "albatros@gmail.com";

    private final JavaMailSender mailSender;

    public void send(String emailTo, String content) {
        MimeMessagePreparator mimeMessagePreparator = createContent(emailTo, content);
        try {
            mailSender.send(mimeMessagePreparator);
        } catch (MailException e) {
            log.error("Exception when sending email.");
            throw new RuntimeException(e);
        }
    }

    private MimeMessagePreparator createContent(String emailTo, String content) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(EMAIL_SENDER);
            messageHelper.setTo(emailTo);
            messageHelper.setSubject(EMAIL_SUBJECT);
            messageHelper.setText(content);
        };
    }

}
