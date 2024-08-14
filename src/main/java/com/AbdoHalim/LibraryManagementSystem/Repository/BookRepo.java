package com.AbdoHalim.LibraryManagementSystem.Repository;

import com.AbdoHalim.LibraryManagementSystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    @Query(name = "Select * from Book where title=?1",nativeQuery = true)
    Book findByTitle(String title);
}
