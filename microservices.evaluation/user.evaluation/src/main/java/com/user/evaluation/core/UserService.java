package com.user.evaluation.core;


import com.user.evaluation.model.UserModel;

public interface UserService {
    UserModel get(Long userId);
}
