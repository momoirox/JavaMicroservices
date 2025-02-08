package com.user.management.mappers;


import com.user.management.model.UserModel;
import com.user.management.persistence.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel map(UserEntity userEntity);
}
