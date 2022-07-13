package com.sparta.springhw1.repository;

import com.sparta.springhw1.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    boolean existsByUserId(String userId);
}
