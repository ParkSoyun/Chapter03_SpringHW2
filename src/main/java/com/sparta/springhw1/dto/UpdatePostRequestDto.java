package com.sparta.springhw1.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class UpdatePostRequestDto {
    private String title;
    private String content;

    public UpdatePostRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
