package com.example.bookMS.model;

public class BookMapper {

    // BookDTO -> Book Entity (생성용)
    // bookId, createdAt, updatedAt은 자동 생성되므로 포함하지 않음
    public static Book toEntity(BookDTO dto) {
        return Book.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .coverImageUrl(dto.getCoverImageUrl())
                .build();
    }

    // Book Entity -> BookDTO
    public static BookDTO toDTO(Book book) {
        return BookDTO.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .content(book.getContent())
                .coverImageUrl(book.getCoverImageUrl())
                .createdAt(book.getCreatedAt())
                .updatedAt(book.getUpdatedAt())
                .build();
    }

    // BookDTO로 Entity 업데이트
    // bookId, createdAt, updatedAt은 변경하지 않음
    public static void updateEntity(Book book, BookDTO dto) {
        if (dto.getTitle() != null) {
            book.setTitle(dto.getTitle());
        }
        if (dto.getContent() != null) {
            book.setContent(dto.getContent());
        }
        if (dto.getCoverImageUrl() != null) {
            book.setCoverImageUrl(dto.getCoverImageUrl());
        }
    }
}