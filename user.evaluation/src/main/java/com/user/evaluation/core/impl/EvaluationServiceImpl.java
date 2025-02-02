package com.user.evaluation.core.impl;

import com.user.evaluation.core.EvaluationService;
import com.user.evaluation.dto.UserEvaluationModel;
import com.user.evaluation.mappers.UserEvaluationMapper;
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
    private final UserEvaluationMapper userEvaluationMapper;
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
        return userEvaluationMapper.map(evaluationRepository.getByUserId(id));
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
