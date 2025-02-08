package com.user.evaluation.persistence;

import com.user.evaluation.enums.MonthEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EvaluationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    String evaluationComment;

    @Enumerated(EnumType.STRING)
    MonthEnum month;

    Long refUser;
}
