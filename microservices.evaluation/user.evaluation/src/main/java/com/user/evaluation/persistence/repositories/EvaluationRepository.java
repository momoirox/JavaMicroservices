package com.user.evaluation.persistence.repositories;

import com.user.evaluation.persistence.EvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Long> {
}
