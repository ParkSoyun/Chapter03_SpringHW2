package com.sparta.springhw1.domain;

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

    @Column(name = "post_id_fk", nullable = false)
    private Long postId;

    @Column(name = "user_id_fk", length = 15, nullable = false)
    private String writer;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
}
