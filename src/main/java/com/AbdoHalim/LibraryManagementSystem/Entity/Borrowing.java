package com.AbdoHalim.LibraryManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "book_id",referencedColumnName = "bookId")
    private Book book;
    @OneToOne
    @JoinColumn(name = "patron_id",referencedColumnName = "patronId")
    private Patron patron;
    private LocalDateTime borrowingDate;
    private LocalDateTime returnDate;
    private BorrowingStatus status;



}
