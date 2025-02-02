package com.user.evaluation.dto;

import com.user.evaluation.enums.MonthEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserEvaluationModel {
    private UserModel userModel;
    private Long evaluationId;
    private String evaluationComment;
    private MonthEnum month;
}
