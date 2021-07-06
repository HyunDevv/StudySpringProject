package com.fastcampus.jpa.bookmanager.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void test(){
        User user = new User();
        user.setEmail("jaehyun@fastcampus.com");
        user.setName("jaehyun");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User user1 = new User(null,"jaehyun","jaehyun@fastcampus.com", LocalDateTime.now(), LocalDateTime.now());
        User user2 = new User("martin", "martin@fastcampus.com");

        User user3 = User.builder()
                .name("martin")
                .email("martin@fastcampus.com")
                .build();


        System.out.println(">>>" + user);
    }
}