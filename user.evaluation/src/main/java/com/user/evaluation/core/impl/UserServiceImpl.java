package com.user.evaluation.core.impl;

import com.user.evaluation.core.UserService;
import com.user.evaluation.dto.UserEvaluationModel;
import com.user.evaluation.dto.UserModel;
import com.user.evaluation.persistence.EvaluationEntity;
import com.user.evaluation.persistence.UserEntity;
import com.user.evaluation.persistence.repositories.EvaluationRepository;
import com.user.evaluation.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EvaluationRepository evaluationRepository;


    @Override
    public List<UserModel> getAll() {
        List<UserEntity> all = userRepository.findAll();
        return all.stream()
                .map(this::map)
                .toList();
    }

    @Override
    public UserModel save(UserModel request) {
        UserEntity saved = userRepository.save(map(request));
        request.setId(saved.getId());
        return request;
    }

    @Override
    public UserModel get(Long id) {
        return map(userRepository.getReferenceById(id));
    }

    @Override
    public UserEvaluationModel getEvaluations(Long id) {
        UserEntity user = userRepository.getReferenceById(id);
        EvaluationEntity evaluation = evaluationRepository.getByUserId(id);

        UserEvaluationModel response = new UserEvaluationModel();
        response.setUserModel(map(user));
        response.setEvaluationId(evaluation.getId());
        response.setEvaluationComment(evaluation.getEvaluationComment());
        response.setMonth(evaluation.getMonth());

        return response;
    }

    private UserModel map(UserEntity user) {
        UserModel request = new UserModel();
        request.setId(user.getId());
        request.setFirstName(user.getFirstName());
        request.setLastName(user.getLastName());
        request.setJobDescription(user.getJobDescription());

        return request;
    }

    private UserEntity map(UserModel request) {
        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setJobDescription(request.getJobDescription());
        return user;
    }
}
