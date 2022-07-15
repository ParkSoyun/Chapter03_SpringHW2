package com.sparta.springhw1.controller;

import com.sparta.springhw1.domain.Comment;
import com.sparta.springhw1.domain.Post;
import com.sparta.springhw1.dto.InsertPostRequestDto;
import com.sparta.springhw1.dto.UpdatePostRequestDto;
import com.sparta.springhw1.security.UserDetailsImpl;
import com.sparta.springhw1.service.CommentService;
import com.sparta.springhw1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {
    private final PostService postService;
    private final CommentService commentService;

    @GetMapping("/")
    public String index() {
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String postList(Model model) {
        List<Post> posts = postService.getPostList();
        model.addAttribute("posts", posts);

        return "posts/postList";
    }

    @GetMapping("/posts/write")
    public String writeForm() {
        return "posts/writePost";
    }

    @PostMapping("/posts/write")
    public String savePost(@AuthenticationPrincipal UserDetailsImpl user, InsertPostRequestDto insertPostRequestDto) {
        Long id = postService.savePost(insertPostRequestDto, user);

        return "redirect:/posts/" + id;
    }

    @GetMapping("/posts/{id}")
    public String detailForm(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable("id") Long id, Model model) {
        Post post = postService.getPost(id);
        List<Comment> comments = commentService.getCommentList(post);

        model.addAttribute("user", user);
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);

        return "posts/postDetail";
    }

    @PostMapping("/posts/{id}")
    public String modifyPostForm(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPost(id);

        model.addAttribute("post", post);

        return "posts/modifyPost";
    }

    @PatchMapping("/posts/{id}")
    public String modifyPost(@PathVariable("id") Long id, UpdatePostRequestDto updateRequestPostDto, Model model) {
        postService.modifyPost(id, updateRequestPostDto);

        Post post = postService.getPost(id);
        model.addAttribute("post", post);

        return "redirect:/posts/" + id;
    }

    @DeleteMapping("/posts/{id}")
    @ResponseBody
    public Long deletePost(@PathVariable("id") Long id) {
        postService.deletePost(id);

        return id;
    }
}
