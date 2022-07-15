package com.sparta.springhw1.controller;

import com.sparta.springhw1.domain.Comment;
import com.sparta.springhw1.domain.Post;
import com.sparta.springhw1.dto.InsertCommentRequestDto;
import com.sparta.springhw1.dto.UpdateCommentRequestDto;
import com.sparta.springhw1.security.UserDetailsImpl;
import com.sparta.springhw1.service.CommentService;
import com.sparta.springhw1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class CommentController {
    private final PostService postService;
    private final CommentService commentService;

    @PostMapping("/comments/{postId}")
    public String saveComment(@PathVariable("postId") Long postId, @AuthenticationPrincipal UserDetailsImpl user, InsertCommentRequestDto insertCommentRequestDto) {
        Post post = postService.getPost(postId);

        commentService.saveComment(post, user, insertCommentRequestDto);

        return "redirect:/posts/" + postId;
    }

    @PatchMapping("/comments/{commentId}")
    @ResponseBody
    public Long modifyComment(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("commentId") Long commentId, @RequestBody UpdateCommentRequestDto updateCommentRequestDto) {
        commentService.modifyComment(commentId, user, updateCommentRequestDto);

        return commentId;
    }

    @DeleteMapping("/comments/{commentId}")
    @ResponseBody
    public Long deleteComment(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId, user);

        return commentId;
    }
}
