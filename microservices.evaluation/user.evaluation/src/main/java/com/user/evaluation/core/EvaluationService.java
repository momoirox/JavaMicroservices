package com.user.evaluation.core;

import com.user.evaluation.core.model.UserEvaluationModel;

import java.util.List;

public interface EvaluationService {
    UserEvaluationModel save(UserEvaluationModel model);

    UserEvaluationModel get(Long id);

    void delete(Long id);

    List<UserEvaluationModel> getAll();
}
