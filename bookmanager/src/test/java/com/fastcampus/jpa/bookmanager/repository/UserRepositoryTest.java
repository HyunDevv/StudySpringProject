package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Gender;
import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
//    @Transactional
    void crud1(){
//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
//        List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));

//        User user1 = new User("jack", "jack@fastcampus.com");
//        User user2 = new User("steve", "steve@fastcampus.com");
//        userRepository.saveAll(Lists.newArrayList(user1, user2));

//        User user = userRepository.getOne(1L); // getOne은 entitiy에 대한 lazy한 로딩을 지원한다 - @Transactional 필요
//        User user = userRepository.findById(1L).orElse(null); // getOne은 entitiy에 대한 lazy한 로딩을 지원한다 - @Transactional 필요
//        System.out.println(user);

        List<User> users = userRepository.findAll();

        users.forEach(System.out::println);
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

    @Test
    void crud3(){
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@fastcampus.com");

        userRepository.save(user);
    }

    @Test
    void select(){
//        System.out.println(userRepository.findByName("dennis"));
//
//        System.out.println("findByEmail : " + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@fastcampus.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@fastcampus.com"));
//        System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("martin@fastcampus.com"));
//
//        System.out.println("findTop2ByName : " + userRepository.findTop2ByName("martin"));
//        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("martin"));

        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com", "martin"));

        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));

        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));

        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//        System.out.println("findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());

        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));

        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
        System.out.println("findByNameContains : " + userRepository.findByNameContains("rti"));
        System.out.println("findByNameLike : " + userRepository.findByNameLike("%" + "art" +"%"));



    }

    @Test
    void pagingAndSortingTest(){
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("martin"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));

        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));

        System.out.println("findByNameWithPaging : " + userRepository.findAll(PageRequest.of(0, 3)).getContent());
        System.out.println("findByNameWithPaging : " + userRepository.findAll(PageRequest.of(0, 3)).getTotalElements());


    }

    @Test
    void insertAndUpdateTest(){
        User user = new User();
        user.setName("martin");
        user.setEmail("martin2@fastcampus.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrtin");

        userRepository.save(user2);
    }

    @Test
    void enumTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MAIL);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRawRecord().get("gender"));
    }

    @Test
    void listenerTest(){
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrtin");

        userRepository.save(user2);

        userRepository.deleteById(4L);

    }

    @Test
    void prePersistTest(){
        User user = new User();
        user.setEmail("martin2@fastcampus.com");
        user.setName("martin");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("martin2@fastcampus.com"));
    }

    @Test
    void preUpdateTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("martin22");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest(){
        User user = new User();
        user.setEmail("martin-new@fastcampus.com");
        user.setName("martin-new");

        userRepository.save(user);

        user.setName("maritin-new-new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }

    @Test
    void userRelationTest(){
        User user = new User();
        user.setName("david");
        user.setEmail("david@fastcampus.com");
        user.setGender(Gender.MAIL);
        userRepository.save(user);

        user.setName("daniel");
        userRepository.save(user);

        user.setEmail("daniel@fastcampus.com");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("daniel@fastcampus.com").getId());
        List<UserHistory> result = userRepository.findByEmail("daniel@fastcampus.com").getUserHistories();

        result.forEach(System.out::println);

        System.out.println("UserHistory.getUser() : " + userHistoryRepository.findAll().get(0).getUser()) ;
    }

}