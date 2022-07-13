package com.sparta.springhw1.dto;

import com.sparta.springhw1.form.InsertUserForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
public class InsertUserRequestDto {
    private String id;
    private String name;
    private String password;
    private String passwordCheck;

    public InsertUserRequestDto(String id, String name, String password, String passwordCheck) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.passwordCheck = passwordCheck;
    }

    public InsertUserRequestDto(InsertUserForm insertUserForm) {
        this.id = insertUserForm.getId();
        this.name = insertUserForm.getName();
        this.password = insertUserForm.getPassword();
        this.passwordCheck = insertUserForm.getPasswordCheck();
    }
}
