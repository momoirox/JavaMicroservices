package com.user.evaluation.core;


import com.user.evaluation.dto.UserEvaluationModel;
import com.user.evaluation.dto.UserModel;

import java.util.List;

public interface UserService {
    UserModel save(UserModel request);

    UserModel get(Long id);

    UserEvaluationModel getEvaluations(Long id);

    List<UserModel> getAll();
}
