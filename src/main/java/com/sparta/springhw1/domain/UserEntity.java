package com.sparta.springhw1.domain;

import com.sparta.springhw1.dto.InsertUserRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "user_table")
public class UserEntity {
    @Id
    @Column(name = "user_id", length = 20)
    private String userId;

    @Column(length = 15, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    public UserEntity(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public UserEntity(InsertUserRequestDto insertUserRequestDto) {
        this.userId = insertUserRequestDto.getId();
        this.name = insertUserRequestDto.getName();
        this.password = insertUserRequestDto.getPassword();
    }
}
