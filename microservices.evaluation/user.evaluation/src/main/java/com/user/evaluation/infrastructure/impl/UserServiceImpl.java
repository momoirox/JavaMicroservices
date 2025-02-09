package com.user.evaluation.infrastructure.impl;

import com.user.evaluation.infrastructure.UserService;
import com.user.evaluation.infrastructure.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final WebClient webClient;

    @Value("${services.user-management}")
    private String userManagementServiceUrl;

    @Override
    public UserModel get(Long userId) {
        return webClient.get()
                .uri(userManagementServiceUrl + userId)
                .retrieve()
                .bodyToMono(UserModel.class)
                .block();
    }
}
