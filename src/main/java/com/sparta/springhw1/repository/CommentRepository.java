package com.sparta.springhw1.repository;

import com.sparta.springhw1.domain.Comment;
import com.sparta.springhw1.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostOrderByCreatedAtAsc(Post post);
}
