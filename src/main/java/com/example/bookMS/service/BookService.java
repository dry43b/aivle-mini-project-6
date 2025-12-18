package com.example.bookMS.service;

import com.example.bookMS.model.BookDTO;

import java.util.List;

public interface BookService {

    // 도서 생성
    BookDTO createBook(BookDTO bookDTO);

    // 도서 목록 조회
    List<BookDTO> getBookList();

    // 도서 단건 조회
    BookDTO getBook(Long bookId);

    // 도서 수정
    BookDTO updateBook(Long bookId, BookDTO bookDTO);

    // 도서 삭제
    void deleteBook(Long bookId);

    // 도서 표지 이미지 수정
    BookDTO updateBookCover(Long bookId, String coverUrl);
}