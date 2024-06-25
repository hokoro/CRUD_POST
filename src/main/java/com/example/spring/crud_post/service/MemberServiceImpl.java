package com.example.spring.crud_post.service;

import com.example.spring.crud_post.domain.User;
import com.example.spring.crud_post.dto.LoginDTO;
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

    @Override
    public ResponseEntity login(LoginDTO loginDTO){
        Optional<User> member = memberRepository.findById(loginDTO.getId());
        User memberEntity = member.orElse(null);

        if(member == null){ // 입력한 로그인 데이터가 없을 경우
            return new ResponseEntity("해당 아이디를 가진 회원이 존재하지 않습니다." , HttpStatus.OK);
        }
        if(memberEntity.getPassword().equals(loginDTO.getPassword())){
            return new ResponseEntity("success" , HttpStatus.OK);
        }else{
            return new ResponseEntity("비밀번호가 일치하지 않습니다" ,HttpStatus.OK);
        }

    }
}
