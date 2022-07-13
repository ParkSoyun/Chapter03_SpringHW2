package com.sparta.springhw1.repository;

import com.sparta.springhw1.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
