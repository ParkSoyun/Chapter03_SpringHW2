package com.sparta.springhw1.controller;

import com.sparta.springhw1.domain.Post;
import com.sparta.springhw1.dto.RequestPostDto;
import com.sparta.springhw1.dto.UpdateRequestPostDto;
import com.sparta.springhw1.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

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
    public String savePost(RequestPostDto requestPostDto) {
        Long id = postService.savePost(requestPostDto);

        return "redirect:/posts/" + id;
    }

    @GetMapping("/posts/{id}")
    public String detailForm(@PathVariable("id") Long id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);

        return "posts/postDetail";
    }

    @PostMapping("/posts/{id}")
    public String checkPassword(@PathVariable("id") Long id, @RequestParam(value = "password") String inputPassword, Model model) {
        Post post = postService.getPost(id);

        boolean checkPassword = postService.checkPassword(inputPassword, post);

        model.addAttribute("post", post);

        if(checkPassword) {
            return "posts/modifyPost";
        } else {
            model.addAttribute("result", "비밀번호가 틀렸습니다.");

            return "posts/postDetail";
        }
    }

    @PatchMapping("/posts/{id}")
    public String modifyPost(@PathVariable("id") Long id, UpdateRequestPostDto updateRequestPostDto, Model model) {
        postService.modifyPost(id, updateRequestPostDto);

        Post post = postService.getPost(id);
        model.addAttribute("post", post);

        return "redirect:/posts/" + id;
    }

    @DeleteMapping("/posts/{id}")
    @ResponseBody
    public Long deletePost(@PathVariable("id") Long id, @RequestParam(value = "password") String inputPassword) {
        Post post = postService.getPost(id);

        boolean checkPassword = postService.checkPassword(inputPassword, post);

        if(checkPassword) {
            postService.deletePost(id);

            return id;
        } else {
            return 0L;
        }
    }
}
