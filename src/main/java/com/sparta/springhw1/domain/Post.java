package com.sparta.springhw1.domain;

import com.sparta.springhw1.dto.RequestPostDto;
import com.sparta.springhw1.dto.UpdateRequestPostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicUpdate
@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post(RequestPostDto postDto) {
        this.title = postDto.getTitle();
        this.writer = postDto.getWriter();
        this.password = postDto.getPassword();
        this.content = postDto.getContent();
    }

    public void update(UpdateRequestPostDto updateRequestPostDto) {
        this.title = updateRequestPostDto.getTitle();
        this.content = updateRequestPostDto.getContent();
    }
}
