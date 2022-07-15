package com.sparta.springhw1.service;

import com.sparta.springhw1.domain.Post;
import com.sparta.springhw1.dto.InsertPostRequestDto;
import com.sparta.springhw1.dto.UpdatePostRequestDto;
import com.sparta.springhw1.repository.PostRepository;
import com.sparta.springhw1.security.UserDetailsImpl;
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

    public Long savePost(InsertPostRequestDto insertPostRequestDto, UserDetailsImpl user) {
        Post post = new Post(insertPostRequestDto, user);

        postRepository.saveAndFlush(post);

        return post.getPostId();
    }

    public boolean isWriter(Long postId, UserDetailsImpl user) {
        Post post = postRepository.findById(postId).get();

        String currentUser = user.getUserId();
        String writer = post.getUser().getUserId();

        return currentUser.equals(writer);
    }

    public void modifyPost(Long postId, UserDetailsImpl user, UpdatePostRequestDto updateRequestPostDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        if(isWriter(postId, user)) {
            post.update(updateRequestPostDto);
        }
    }

    public void deletePost(Long postId, UserDetailsImpl user) {
        if(isWriter(postId, user)) {
            postRepository.deleteById(postId);
        }
    }
}
