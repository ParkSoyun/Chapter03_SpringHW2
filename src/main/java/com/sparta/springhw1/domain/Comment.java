package com.sparta.springhw1.domain;

import com.sparta.springhw1.dto.InsertCommentRequestDto;
import com.sparta.springhw1.dto.UpdateCommentRequestDto;
import com.sparta.springhw1.security.UserDetailsImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "comment")
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    public Comment(Post post, UserDetailsImpl user, InsertCommentRequestDto insertCommentRequestDto) {
        this.post = post;
        this.user = user.getUser();
        this.content = insertCommentRequestDto.getContent();
    }

    public void update(UpdateCommentRequestDto updateCommentRequestDto) {
        this.content = updateCommentRequestDto.getContent();
    }
}
