package com.user.evaluation.infrastructure;

public interface NotificationService {
    void notify(String email);

    void notify(String email, String message);
}
