package com.example.bookMS.service;

import com.example.bookMS.exception.ResourceNotFoundException;
import com.example.bookMS.model.*;
import com.example.bookMS.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = BookMapper.toEntity(bookDTO);
        bookRepository.save(book);
        return BookMapper.toDTO(book);
    }

    @Override
    public List<BookDTO> getBookList() {
        List<Book> bookList = bookRepository.findAll();
        return bookList.stream()
                .map(BookMapper::toDTO)
                .toList();
    }

    @Override
    public BookDTO getBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("존재하지 않는 책입니다. ID: " + bookId));
        return BookMapper.toDTO(book);
    }

    @Override
    @Transactional
    public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("존재하지 않는 책입니다. ID: " + bookId));

        BookMapper.updateEntity(book, bookDTO);
        bookRepository.save(book);
        return BookMapper.toDTO(book);
    }

    @Override
    @Transactional
    public void deleteBook(Long bookId) {
        if (!bookRepository.existsById(bookId)) {
            throw new ResourceNotFoundException("존재하지 않는 책입니다. ID: " + bookId);
        }
        bookRepository.deleteById(bookId);
    }

    @Override
    @Transactional
    public BookDTO updateBookCover(Long bookId, String coverUrl) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("존재하지 않는 책입니다. ID: " + bookId));

        book.setCoverImageUrl(coverUrl);
        bookRepository.save(book);
        return BookMapper.toDTO(book);
    }
}