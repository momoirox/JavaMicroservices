package com.user.evaluation.core.model;

import com.user.evaluation.core.enums.MonthEnum;
import com.user.evaluation.infrastructure.model.UserModel;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEvaluationModel {
    private UserModel userModel;
    private Long evaluationId;
    private String evaluationComment;
    private MonthEnum month;
}
