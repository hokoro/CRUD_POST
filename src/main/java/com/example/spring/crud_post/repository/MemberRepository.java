package com.example.spring.crud_post.repository;

import com.example.spring.crud_post.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<User, String> {
}
