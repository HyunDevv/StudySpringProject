package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void put(){
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");

//        userRepository.save(user);
        entityManager.persist(user);
//        entityManager.detach(user);

        user.setName("newUserAfterPersist"); // transaction이 종료되는 시점에 update 쿼리가 실해되어 반영이 된다, persist 상태면 적용!
        entityManager.merge(user);
//        entityManager.flush();
//        entityManager.clear();

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);

//        user1.setName("marrrrrrtin");
//        entityManager.merge(user1);

        // 영속성 컨텍스트가 엔티티를 관리하고 있는 상태인지 생각해야함!
    }
}
