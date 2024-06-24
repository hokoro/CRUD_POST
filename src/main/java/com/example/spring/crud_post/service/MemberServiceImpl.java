package com.example.spring.crud_post.service;

import com.example.spring.crud_post.domain.User;
import com.example.spring.crud_post.dto.SignUpFormDTO;
import com.example.spring.crud_post.repository.MemberRepository;
import com.example.spring.crud_post.service.interfaces.MemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    public ResponseEntity signup(SignUpFormDTO formDTO){
        Optional<User> member = memberRepository.findById(formDTO.getId());
        if(member.isEmpty()){
            User newMember = User.builder()
                    .id(formDTO.getId())
                    .password(formDTO.getPassword())
                    .name(formDTO.getName())
                    .role(false)
                    .build();
            memberRepository.save(newMember);

            return new ResponseEntity("success", HttpStatus.OK);
        }else{
            return new ResponseEntity("fail",HttpStatus.OK);
        }
    }
}
