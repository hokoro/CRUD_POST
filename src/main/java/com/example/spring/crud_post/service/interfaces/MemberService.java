package com.example.spring.crud_post.service.interfaces;

import com.example.spring.crud_post.dto.LoginDTO;
import com.example.spring.crud_post.dto.SignUpFormDTO;
import org.springframework.http.ResponseEntity;

public interface MemberService {
    ResponseEntity signup(SignUpFormDTO formDTO);

    ResponseEntity login(LoginDTO loginDTO);


}
