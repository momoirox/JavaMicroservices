package com.user.management.core.mappers;


import com.user.management.core.model.UserModel;
import com.user.management.persistence.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel map(UserEntity userEntity);

    @InheritInverseConfiguration
    UserEntity map(UserModel userModel);
}
