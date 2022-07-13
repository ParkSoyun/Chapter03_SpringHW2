package com.sparta.springhw1.form;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class InsertUserForm {
    @NotBlank(message = "아이디를 입력해주세요.")
    @Length(min = 3, max = 20, message = "아이디는 3자 이상, 20자 이하로 입력해주세요.")
    @Pattern(regexp = "^[A-Z|a-z|0-9]{3,20}$", message = "조건에 부합하지 않은 아이디입니다.")
    private String id;

    @NotBlank(message = "이름을 입력해주세요.")
    @Length(max = 15, message = "15자 이하로 입력해주세요.")
    private String name;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Length(min = 4, max = 16, message = "비밀번호는 4자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @NotBlank(message = "비밀번호 확인을 입력해주세요.")
    private String passwordCheck;
}
