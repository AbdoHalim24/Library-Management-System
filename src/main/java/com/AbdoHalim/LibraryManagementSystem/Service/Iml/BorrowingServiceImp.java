package com.AbdoHalim.LibraryManagementSystem.Service.Iml;

import com.AbdoHalim.LibraryManagementSystem.Entity.Book;
import com.AbdoHalim.LibraryManagementSystem.Entity.Borrowing;
import com.AbdoHalim.LibraryManagementSystem.Entity.BorrowingStatus;
import com.AbdoHalim.LibraryManagementSystem.Entity.Patron;
import com.AbdoHalim.LibraryManagementSystem.Repository.BookRepo;
import com.AbdoHalim.LibraryManagementSystem.Repository.BorrowingRepo;
import com.AbdoHalim.LibraryManagementSystem.Repository.PatronRepo;
import com.AbdoHalim.LibraryManagementSystem.Service.BorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowingServiceImp implements BorrowingService {
    private final BorrowingRepo borrowingRepo;
    private final BookRepo bookRepo;
    private final PatronRepo patronRepo;

    @Override
    @Transactional
    public ResponseEntity<String> makeBorrowing(int bookId, int patronId) {
        Optional<Book> book= bookRepo.findById((long) bookId);
        Optional<Patron> patron=patronRepo.findById((long)patronId);
        if (book.isEmpty()){
            return ResponseEntity.badRequest().body("Book with this id not exist");
        }
        if (patron.isEmpty()){
            return ResponseEntity.badRequest().body("Patron with this id not exist");
        }
        Borrowing borrowing=new Borrowing();
        borrowing.setBook(book.get());
        borrowing.setPatron(patron.get());
        borrowing.setStatus(BorrowingStatus.NotReturned);
        borrowing.setBorrowingDate(LocalDateTime.now());
        borrowingRepo.save(borrowing);
        return ResponseEntity.ok("Operation Done Successfully");
    }

    @Override
    @Transactional
    public ResponseEntity<String> ReturnBorrowing(int bookId, int patronId) {
        Optional<Book> book= bookRepo.findById((long) bookId);
        Optional<Patron> patron=patronRepo.findById((long)patronId);
        if (book.isEmpty()){
            return ResponseEntity.badRequest().body("Book with this id not exist");
        }
        if (patron.isEmpty()){
            return ResponseEntity.badRequest().body("Patron with this id not exist");
        }
        Borrowing borrowing=borrowingRepo.getBorrowing((long)bookId,(long)patronId);
        if (borrowing==null){
            return ResponseEntity.badRequest().body("there is no Borrowing operation ");
        }
        borrowing.setReturnDate(LocalDateTime.now());
        borrowing.setStatus(BorrowingStatus.Returned);

        return ResponseEntity.ok("Returned operation done");
    }
}
