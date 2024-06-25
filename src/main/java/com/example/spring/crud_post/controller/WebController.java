package com.example.spring.crud_post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    // 메인 홈페이지
    @GetMapping("/")
    public String index(){
        return "home";
    }

    // 회원가입 페이지
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    // 로그인 페이지
    @GetMapping("/signin")
    public String signin(){
        return "signin";
    }
}
