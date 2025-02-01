package com.user.evaluation.persistence.repositories;

import com.user.evaluation.persistence.EvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Long> {

    @Query("select e " +
            "from EvaluationEntity e " +
            "where e.user.id = :id ")
    EvaluationEntity getByUserId(Long id);
}
