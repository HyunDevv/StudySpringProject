package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Long> { // <엔티티의 타입, PK의 타입>
    Set<User> findByName(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    User findSomethingByEmail(String email);

//    User findByByEmail(String email); 잘못된..

    User findFirst1ByName(String name);
    List<User> findTop2ByName(String name);

//    List<User> findLast1ByName(String name); 사용불가 키워드 Last

}
