package com.user.evaluation.mappers;

import com.user.evaluation.dto.UserModel;
import com.user.evaluation.persistence.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserModel map(UserEntity userEntity);
}
