package com.sparta.springhw1.service;

import com.sparta.springhw1.domain.Comment;
import com.sparta.springhw1.domain.Post;
import com.sparta.springhw1.dto.InsertCommentRequestDto;
import com.sparta.springhw1.dto.UpdateCommentRequestDto;
import com.sparta.springhw1.repository.CommentRepository;
import com.sparta.springhw1.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> getCommentList(Post post) {
        List<Comment> comments = commentRepository.findAllByPostOrderByCreatedAtAsc(post);

        return comments;
    }

    public Long getPostId(Long commentId) {
        Long postId = commentRepository.findById(commentId).get().getPost().getPostId();

        return postId;
    }

    public void saveComment(Post post, UserDetailsImpl user, InsertCommentRequestDto insertCommentRequestDto) {
        Comment comment = new Comment(post, user, insertCommentRequestDto);

        commentRepository.save(comment);

    }

    public void modifyComment(Long commentId, UpdateCommentRequestDto updateCommentRequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        comment.update(updateCommentRequestDto);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
