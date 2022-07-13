package com.sparta.springhw1.dto;

import lombok.Getter;

@Getter
public class InsertCommentRequestDto {
    private Long postId;
    private String userId;
    private String content;

    public InsertCommentRequestDto(Long postId, String userId, String content) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
    }
}
