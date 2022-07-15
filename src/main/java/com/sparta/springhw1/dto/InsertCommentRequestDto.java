package com.sparta.springhw1.dto;

import com.sparta.springhw1.domain.Post;
import com.sparta.springhw1.domain.UserEntity;
import lombok.Getter;

@Getter
public class InsertCommentRequestDto {
    private String content;

    public InsertCommentRequestDto(String content) {
        this.content = content;
    }
}
