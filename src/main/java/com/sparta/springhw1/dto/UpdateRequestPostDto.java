package com.sparta.springhw1.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateRequestPostDto {
    private String title;
    private String content;

    public UpdateRequestPostDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
