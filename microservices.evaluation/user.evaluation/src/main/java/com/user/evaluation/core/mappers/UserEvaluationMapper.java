package com.user.evaluation.core.mappers;

import com.user.evaluation.core.model.UserEvaluationModel;
import com.user.evaluation.persistence.EvaluationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEvaluationMapper {

    @Mapping(target = "evaluationId", source = "id")
    UserEvaluationModel map(EvaluationEntity source);
}
