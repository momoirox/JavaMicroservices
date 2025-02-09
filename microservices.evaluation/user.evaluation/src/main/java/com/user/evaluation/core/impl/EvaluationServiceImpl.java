package com.user.evaluation.core.impl;

import com.user.evaluation.infrastructure.NotificationService;
import com.user.evaluation.core.EvaluationService;
import com.user.evaluation.infrastructure.UserService;
import com.user.evaluation.core.mappers.UserEvaluationMapper;
import com.user.evaluation.core.model.UserEvaluationModel;
import com.user.evaluation.infrastructure.model.UserModel;
import com.user.evaluation.persistence.EvaluationEntity;
import com.user.evaluation.persistence.repositories.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {
    private final UserService userService;
    private final NotificationService notificationService;
    private final UserEvaluationMapper userEvaluationMapper;
    private final EvaluationRepository evaluationRepository;

    @Override
    public UserEvaluationModel save(UserEvaluationModel model) {
        Long userId = model.getUserModel().getId();
        EvaluationEntity evaluation = new EvaluationEntity();
        evaluation.setEvaluationComment(model.getEvaluationComment());
        evaluation.setMonth(model.getMonth());
        evaluation.setRefUser(userId);

        evaluationRepository.save(evaluation);

        UserModel userModel = userService.get(userId);
        notificationService.notify(userModel.getEmail());

        model.setEvaluationId(evaluation.getId());
        return model;
    }

    @Override
    public UserEvaluationModel get(Long id) {
        EvaluationEntity evaluation = evaluationRepository.getReferenceById(id);
        UserEvaluationModel model = userEvaluationMapper.map(evaluation);
        model.setUserModel(userService.get(evaluation.getRefUser()));
        return model;
    }

    @Override
    public void delete(Long id) {
        evaluationRepository.deleteById(id);
    }

    @Override
    public List<UserEvaluationModel> getAll() {
        return evaluationRepository.findAll().stream()
                .map(userEvaluationMapper::map)
                .toList();
    }
}
