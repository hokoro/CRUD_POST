package com.example.spring.crud_post.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="board_id" , nullable = false)
    private Integer id;

    @Column(name="board_title" , length = 20 ,nullable = false)
    private String title;

    @Column(name="board_content" , columnDefinition = "TEXT" , nullable = false)
    private String content;

    @Column(name="board_created_at" , nullable = false)
    private LocalDateTime createdAt;

    @Column(name="board_updated_at" , nullable = false)
    private LocalDateTime updatedAt;

    @Column(name="board_views",nullable = false)
    private Integer views;

    @Column(name = "board_likes" , nullable = false)
    private Integer likes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id",nullable = false)
    private User user;


}
