package com.AbdoHalim.LibraryManagementSystem.Service;

import com.AbdoHalim.LibraryManagementSystem.DTO.BookDTO;
import com.AbdoHalim.LibraryManagementSystem.Entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    ResponseEntity<List<Book>> RetrieveAllBooks();

    ResponseEntity<Book> RetrieveBook(int id);

    ResponseEntity<String> addBook(BookDTO bookDTO);

    ResponseEntity<String> updateBook(BookDTO bookDTO, int id);

    ResponseEntity<String> deleteBook(int id);
}
