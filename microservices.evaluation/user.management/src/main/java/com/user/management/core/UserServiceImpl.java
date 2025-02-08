package com.user.management.core;


import com.user.management.mappers.UserMapper;
import com.user.management.model.UserModel;
import com.user.management.persistence.UserEntity;
import com.user.management.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;


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

    private UserEntity map(UserModel request) {
        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setJobDescription(request.getJobDescription());
        return user;
    }
}
