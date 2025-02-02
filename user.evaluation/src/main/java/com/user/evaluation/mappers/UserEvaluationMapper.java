package com.user.evaluation.mappers;

import com.user.evaluation.dto.UserEvaluationModel;
import com.user.evaluation.persistence.EvaluationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface UserEvaluationMapper {

    @Mapping(target = "evaluationId", source = "id")
    @Mapping(target = "userModel", source = "user")
    UserEvaluationModel map(EvaluationEntity source);
}
