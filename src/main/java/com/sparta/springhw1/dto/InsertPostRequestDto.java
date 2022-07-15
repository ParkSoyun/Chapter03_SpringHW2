package com.sparta.springhw1.dto;

import com.sparta.springhw1.domain.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
public class InsertPostRequestDto {
    private String title;
    private String content;

    public InsertPostRequestDto(String title, String content)
    {
        this.title = title;
        this.content = content;
    }
}
