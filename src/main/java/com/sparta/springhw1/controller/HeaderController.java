package com.sparta.springhw1.controller;

import com.sparta.springhw1.security.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HeaderController {
    @GetMapping("/header")
    public String postList(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        if(user != null) {
            model.addAttribute("user", user);
        }

        System.out.println("hihi" + user.getUserId());

        return "header/mainHeader";
    }
}
