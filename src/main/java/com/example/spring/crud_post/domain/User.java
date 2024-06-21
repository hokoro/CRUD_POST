package com.example.spring.crud_post.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Getter  //lombok 에서 제공하는 getter 메소드 어노테이션
@Entity    //JPA를 사용해서 테이블과 매핑할때
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @Column(name="member_id",length = 20,nullable = false)
    private String id;

    @Column(name="member_password",length = 30 , nullable = false)
    private String password;

    @Column(name="member_name", length = 15 , nullable = false)
    private String name;

    @Column(name="member_role",nullable = false)
    private Boolean role;
}
