package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
public class EntityManagerTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    void entityManagerTest(){
        System.out.println(entityManager.createQuery("select u from User u").getResultList());
    }

    @Test
    void cacheFineTest(){
        System.out.println(userRepository.findById(1L).get());
        System.out.println(userRepository.findById(1L).get()); // 아이디로 조회할때 위 쿼리에서 jpa에 있는 1차캐쉬에 저장된 것을 가져오기 때문에 다시 db에서 select 하지 않는다
        System.out.println(userRepository.findById(1L).get());

        userRepository.deleteById(1L);
    }

    @Test
    void cacheFindTest2(){
        User user = userRepository.findById(1L).get();
        user.setName("marrrrrtin");

        userRepository.save(user);

        System.out.println("-----------------------");

        user.setEmail("marrrrrrtin@fastcampus.com");
        userRepository.save(user);


        System.out.println(userRepository.findAll());
    }

}
