package com.AbdoHalim.LibraryManagementSystem.Service;

import org.springframework.http.ResponseEntity;

public interface BorrowingService {
    ResponseEntity<String> makeBorrowing(int bookId, int patronId);

    ResponseEntity<String> ReturnBorrowing(int bookId, int patronId);
}
