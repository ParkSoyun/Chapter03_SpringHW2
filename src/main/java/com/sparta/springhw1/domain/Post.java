package com.sparta.springhw1.domain;

import com.sparta.springhw1.dto.InsertPostRequestDto;
import com.sparta.springhw1.dto.UpdatePostRequestDto;
import com.sparta.springhw1.security.UserDetailsImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.userdetails.UserDetails;

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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Post(InsertPostRequestDto insertPostRequestDto, UserDetailsImpl user) {
        this.title = insertPostRequestDto.getTitle();
        this.user = user.getUser();
        this.content = insertPostRequestDto.getContent();
    }

    public void update(UpdatePostRequestDto updateRequestPostDto) {
        this.title = updateRequestPostDto.getTitle();
        this.content = updateRequestPostDto.getContent();
    }
}
