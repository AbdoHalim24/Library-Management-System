package com.AbdoHalim.LibraryManagementSystem.Controller;

import com.AbdoHalim.LibraryManagementSystem.DTO.BookDTO;
import com.AbdoHalim.LibraryManagementSystem.Entity.Book;
import com.AbdoHalim.LibraryManagementSystem.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("")
    public ResponseEntity<List<Book>> RetrieveAllBooks(){
        return bookService.RetrieveAllBooks();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> RetrieveBookByID(@PathVariable int id){
        return bookService.RetrieveBook(id);
    }
    @PostMapping("")
    public ResponseEntity<String> addBook(@RequestBody BookDTO bookDTO){
        return bookService.addBook(bookDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@RequestBody BookDTO bookDTO,@PathVariable int id){
        return bookService.updateBook(bookDTO,id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteBook(@PathVariable int id){
        return bookService.deleteBook(id);
    }


}
