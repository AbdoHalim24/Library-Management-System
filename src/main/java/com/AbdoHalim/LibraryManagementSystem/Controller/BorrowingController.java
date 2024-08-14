package com.AbdoHalim.LibraryManagementSystem.Controller;

import com.AbdoHalim.LibraryManagementSystem.Service.BorrowingService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BorrowingController {
    private final BorrowingService borrowingService;
    @PostMapping("/api/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<String>MakeBorrowing(@PathVariable int bookId,@PathVariable int patronId){
        return borrowingService.makeBorrowing(bookId,patronId);
    }
    @PutMapping ("/api/return/{bookId}/patron/{patronId}")
    public ResponseEntity<String>MakeReturnBorrowing(@PathVariable int bookId,@PathVariable int patronId){
        return borrowingService.ReturnBorrowing(bookId,patronId);
    }
}
