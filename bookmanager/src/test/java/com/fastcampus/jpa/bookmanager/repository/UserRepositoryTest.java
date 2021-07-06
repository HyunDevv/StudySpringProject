package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
//    @Transactional
    void crud1(){
//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
//        List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));

//        User user1 = new User("jack", "jack@fastcampus.com");
//        User user2 = new User("steve", "steve@fastcampus.com");
//        userRepository.saveAll(Lists.newArrayList(user1, user2));

//        User user = userRepository.getOne(1L); // getOne은 entitiy에 대한 lazy한 로딩을 지원한다 - @Transactional 필요
        User user = userRepository.findById(1L).orElse(null); // getOne은 entitiy에 대한 lazy한 로딩을 지원한다 - @Transactional 필요
        System.out.println(user);

//        List<User> users = userRepository.findAll();
//
//        users.forEach(System.out::println);
    }

    @Test
    void crud2(){
//        userRepository.saveAndFlush(new User("new martin", "newmartin@fastcampus.co."));
//        userRepository.findAll().forEach(System.out::println);

//        boolean exists = userRepository.existsById(1L);
//        System.out.println(exists);
//
//        long count = userRepository.count();
//        System.out.println(count);

//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
//        userRepository.deleteById(1L);
//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,3L)));
//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L)));
//        userRepository.deleteAllInBatch();
//        userRepository.findAll().forEach(System.out::println);



//        Page<User> users = userRepository.findAll(PageRequest.of(0,3));
//
//        System.out.println("page : " + users);
//        System.out.println("total Elements : " + users.getTotalElements());
//        System.out.println("total Pages : " + users.getTotalPages());
//        System.out.println("number Of Elements : " + users.getNumberOfElements());
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize());
//
//        users.getContent().forEach(System.out::println);






//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", endsWith());
//
//        Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);


        User user = new User();
        user.setEmail("slow");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example = Example.of(user, matcher);

        userRepository.findAll(example).forEach(System.out::println);

    }

}