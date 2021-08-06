package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.Author;
import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.repository.AuthorRepository;
import com.fastcampus.jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final EntityManager entityManager;
    private final AuthorService authorService;

//    public void put(){
//        this.putBookAndAuthor(); // @Transactional이 무시된다!
//    }

    @Transactional(propagation = Propagation.REQUIRED) // Transaction이 완료되는 시점에 한꺼번에 commit 한다! / (rollbackFor = Exception.class)는 checked Exception도 롤백시킨다
    public void putBookAndAuthor(){
        Book book = new Book();
        book.setName("JPA 사작하기");

        bookRepository.save(book);

        try{
            authorService.putAuthor();
        }catch(RuntimeException e){
        }

//        Author author = new Author();
//        author.setName("martin");
//
//        authorRepository.save(author);
//
        // checked Exception(롤백안됨) 인지 unchecked Excption(롤백됨, RuntimeException)인지 중요!
//        throw new RuntimeException("오류가 나서 DB commit이 발생하지 않습니다.");
        throw new RuntimeException("오류가 발생하였습니다. transaction은 어떻게 될까요?");
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void get(Long id){
        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        entityManager.clear();

        System.out.println(">>> " + bookRepository.findById(id));
        System.out.println(">>> " + bookRepository.findAll());

        bookRepository.update();

        entityManager.clear();

//        Book book = bookRepository.findById(id).get();
//        book.setName("바뀔까?");
//        bookRepository.save(book);

    }
}
