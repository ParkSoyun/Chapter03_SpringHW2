package com.sparta.springhw1.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class UpdateCommentRequestDto {
    private String content;

    public UpdateCommentRequestDto(String content) {
        this.content = content;
    }
}
