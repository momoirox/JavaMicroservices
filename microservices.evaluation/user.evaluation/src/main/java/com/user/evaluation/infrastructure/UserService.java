package com.user.evaluation.infrastructure;


import com.user.evaluation.infrastructure.model.UserModel;

public interface UserService {
    UserModel get(Long userId);
}
