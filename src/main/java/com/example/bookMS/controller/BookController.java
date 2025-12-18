package com.example.bookMS.controller;

import com.example.bookMS.model.BookDTO;
import com.example.bookMS.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 도서 목록 조회
    @GetMapping
    public ResponseEntity<List<BookDTO>> getBookList() {
        List<BookDTO> bookList = bookService.getBookList();
        return ResponseEntity.ok(bookList);
    }

    // 도서 조회
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> getBook(@PathVariable("bookId") Long bookId) {
        BookDTO book = bookService.getBook(bookId);
        return ResponseEntity.ok(book);
    }

    // 신규 도서 등록
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = bookService.createBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    // 기존 도서 수정
    @PutMapping("/{bookId}")
    public ResponseEntity<BookDTO> updateBook(
            @PathVariable Long bookId,
            @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(bookId, bookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    // 기존 도서 삭제
    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.noContent().build();
    }

    // 기존 도서 표지 수정
    @PatchMapping("/{bookId}/cover")
    public ResponseEntity<BookDTO> updateBookCover(
            @PathVariable Long bookId,
            @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBookCover(bookId, bookDTO.getCoverImageUrl());
        return ResponseEntity.ok(updatedBook);
    }
}