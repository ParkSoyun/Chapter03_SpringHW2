package com.sparta.springhw1.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UpdateCommentRequestDto {
    private String content;
}
