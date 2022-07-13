package com.sparta.springhw1.controller;

import com.sparta.springhw1.dto.InsertUserRequestDto;
import com.sparta.springhw1.form.InsertUserForm;
import com.sparta.springhw1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/users")
@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("insertUserForm", new InsertUserForm());

        return "users/signUp";
    }

    @ResponseBody
    @GetMapping("/signup/{id}")
    public boolean checkExistsId(@PathVariable("id") String userId) {
        return userService.checkExistId(userId);
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("insertUserForm") @Valid InsertUserForm insertUserForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "users/signUp";
        }

        try {
            InsertUserRequestDto insertUserRequestDto = new InsertUserRequestDto(insertUserForm);

            userService.signUp(insertUserRequestDto);
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());

            return "users/signup";
        }

        return "users/signIn";
    }

    @GetMapping("/signin")
    public String signInForm() {
        return "users/signIn";
    }

//    @PostMapping("/signin")
//    public String signIn(SelectUserRequestDto selectUserRequestDto) {
//        boolean result = userService.signIn(selectUserRequestDto);
//
//        if(result) {
//            return "posts/postList";
//        } else {
//            return "users/signIn";
//        }
//    }

    @GetMapping("/signin/error")
    public String signInError(Model model) {
        model.addAttribute("signInErrorMessage", "아이디 또는 비밀번호를 확인해주세요.");

        return "users/signIn";
    }
}
