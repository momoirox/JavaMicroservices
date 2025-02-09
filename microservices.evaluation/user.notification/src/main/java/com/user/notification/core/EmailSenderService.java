package com.user.notification.core;

public interface EmailSenderService {
    void send(String emailTo, String content);
}
