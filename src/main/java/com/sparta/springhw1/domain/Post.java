package com.sparta.springhw1.domain;

import com.sparta.springhw1.dto.InsertPostRequestDto;
import com.sparta.springhw1.dto.UpdatePostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@DynamicUpdate
@NoArgsConstructor
@Getter
@Entity
@Table(name = "post")
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @Column(length = 31, nullable = false)
    private String title;

    @Column(name = "user_id_fk", length = 15, nullable = false)
//    @Column(nullable = false)
    private String writer;

    private String password;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post(InsertPostRequestDto postDto) {
        this.title = postDto.getTitle();
        this.writer = postDto.getWriter();
        this.password = postDto.getPassword();
        this.content = postDto.getContent();
    }

    public void update(UpdatePostRequestDto updateRequestPostDto) {
        this.title = updateRequestPostDto.getTitle();
        this.content = updateRequestPostDto.getContent();
    }
}
