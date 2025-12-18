package com.example.bookMS.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resource, Long id) {
        super(String.format("%s를 찾을 수 없습니다. ID: %d", resource, id));
    }
}