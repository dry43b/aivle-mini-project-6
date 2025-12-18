package com.example.bookMS.repository;

import com.example.bookMS.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/*
Book repository test
intellij에서는 테스트 시 Intellij IDEA를 선택해야 돌아간다.
파일 -> 설정 -> 빌드,실행,배포 -> 빌드 도구 -> Gradle -> 다음을 사용하여 테스트 실행 : Intellij IDEA
 */

@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    void findById_and_Check(){
        Book book = new Book();
        book.setTitle("오디세이");
        book.setContent("호메로스의 대 서사시");
        Book savedBook = bookRepository.save(book);
        Long id = savedBook.getBookId();

        Optional<Book> foundBook = bookRepository.findById(id);

        assertThat(foundBook).isPresent();
        assertThat(foundBook.get().getTitle()).isEqualTo("오디세이");
    }

    @Test
    void findAll_and_Check(){
        Book book1 = new Book();
        book1.setTitle("책 1");
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("책 2");
        bookRepository.save(book2);

        List<Book> bookList = bookRepository.findAll();

        assertThat(bookList.size()).isEqualTo(2);


    }
}
