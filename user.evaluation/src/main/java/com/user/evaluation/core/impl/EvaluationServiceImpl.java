package com.user.evaluation.core.impl;

import com.user.evaluation.core.EvaluationService;
import com.user.evaluation.dto.UserEvaluationModel;
import com.user.evaluation.dto.UserModel;
import com.user.evaluation.persistence.EvaluationEntity;
import com.user.evaluation.persistence.repositories.EvaluationRepository;
import com.user.evaluation.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {

    private final UserRepository userRepository;
    private final EvaluationRepository evaluationRepository;

    @Override
    public UserEvaluationModel save(UserEvaluationModel model) {
        EvaluationEntity evaluation = new EvaluationEntity();
        evaluation.setEvaluationComment(model.getEvaluationComment());
        evaluation.setMonth(model.getMonth());
        evaluation.setUser(userRepository.getReferenceById(model.getUserModel().getId()));

        model.setEvaluationId(evaluation.getId());
        return model;
    }

    @Override
    public UserEvaluationModel get(Long id) {
        return map(evaluationRepository.getByUserId(id));
    }

    private UserEvaluationModel map(EvaluationEntity evaluation) {
        UserEvaluationModel model = new UserEvaluationModel();
        model.setEvaluationComment(evaluation.getEvaluationComment());
        model.setMonth(evaluation.getMonth());
        model.setEvaluationId(evaluation.getId());
        model.setUserModel(new UserModel());

        return model;
    }

    @Override
    public void delete(Long id) {
        evaluationRepository.deleteById(id);
    }

    @Override
    public List<UserEvaluationModel> getAll() {
        return evaluationRepository.findAll().stream()
                .map(this::map)
                .toList();
    }
}
