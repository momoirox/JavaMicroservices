package com.user.management.core;


import com.user.management.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel save(UserModel request);

    UserModel get(Long id);

    List<UserModel> getAll();
}
