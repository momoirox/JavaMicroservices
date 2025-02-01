package com.user.evaluation.persistence.repositories;

import com.user.evaluation.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
