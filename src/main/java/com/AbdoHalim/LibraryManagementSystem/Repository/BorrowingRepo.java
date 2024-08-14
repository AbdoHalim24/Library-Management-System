package com.AbdoHalim.LibraryManagementSystem.Repository;

import com.AbdoHalim.LibraryManagementSystem.Entity.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepo extends JpaRepository<Borrowing, Long> {

    @Query(value = "SELECT * FROM borrowing WHERE book_id = ?1 AND patron_id = ?2", nativeQuery = true)
    Borrowing getBorrowing(Long bookId, Long patronId);
}
