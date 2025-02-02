package com.user.evaluation.core.impl;

import com.user.evaluation.core.UserService;
import com.user.evaluation.dto.UserEvaluationModel;
import com.user.evaluation.dto.UserModel;
import com.user.evaluation.mappers.UserEvaluationMapper;
import com.user.evaluation.mappers.UserMapper;
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

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final UserEvaluationMapper userEvaluationMapper;
    private final EvaluationRepository evaluationRepository;


    @Override
    public List<UserModel> getAll() {
        List<UserEntity> all = userRepository.findAll();
        return all.stream()
                .map(userMapper::map)
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
        return userMapper.map(userRepository.getReferenceById(id));
    }

    @Override
    public UserEvaluationModel getEvaluations(Long id) {
        EvaluationEntity evaluation = evaluationRepository.getByUserId(id);
        return userEvaluationMapper.map(evaluation);
    }

    private UserEntity map(UserModel request) {
        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setJobDescription(request.getJobDescription());
        return user;
    }
}
