package com.sparta.springhw1.service;

import com.sparta.springhw1.domain.Post;
import com.sparta.springhw1.dto.RequestPostDto;
import com.sparta.springhw1.dto.UpdateRequestPostDto;
import com.sparta.springhw1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPostList() {
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();

        return posts;
    }

    public Post getPost(Long id) {
        Post post = postRepository.findById(id).get();

        return post;
    }

    public Long savePost(RequestPostDto postInsertDto) {
        Post post = new Post(postInsertDto);

        postRepository.saveAndFlush(post);

        return post.getPostId();
    }

    public boolean checkPassword(String inputPassword, Post post) {
        String password = post.getPassword();

        if(password.equals(inputPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public void modifyPost(Long id, UpdateRequestPostDto updateRequestPostDto) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        post.update(updateRequestPostDto);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
