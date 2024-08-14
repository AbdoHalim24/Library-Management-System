package com.AbdoHalim.LibraryManagementSystem.Service.Iml;

import com.AbdoHalim.LibraryManagementSystem.DTO.BookDTO;
import com.AbdoHalim.LibraryManagementSystem.Entity.Book;
import com.AbdoHalim.LibraryManagementSystem.Repository.BookRepo;
import com.AbdoHalim.LibraryManagementSystem.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {
    private final BookRepo bookRepo;

    @Override
    public ResponseEntity<List<Book>> RetrieveAllBooks() {
        return ResponseEntity.ok(bookRepo.findAll());
    }

    @Override
    public ResponseEntity<Book> RetrieveBook(int id) {
        Optional<Book> book=bookRepo.findById((long) id);
        if (book.isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(book.get());
    }
    @Override
    @Transactional
    public ResponseEntity<String> addBook(BookDTO bookDTO) {
        if (bookDTO.getAuthor().isEmpty()||bookDTO.getTitle().isEmpty()
                ||bookDTO.getPublicationYear()==null){
            return ResponseEntity.badRequest().body("Enter All fields");
        }
        Book book=bookRepo.findByTitle(bookDTO.getTitle());
        if (book!=null){
            return ResponseEntity.badRequest().body("Book with this title is already exist");
        }
        Book book1=new Book();
        book1.setTitle(bookDTO.getTitle());
        book1.setAuthor(bookDTO.getAuthor());
        book1.setPublicationYear(bookDTO.getPublicationYear());
        bookRepo.save(book1);
        return ResponseEntity.ok("Book Added Successfully");

    }
    @Override
    @Transactional
    public ResponseEntity<String> updateBook(BookDTO bookDTO, int id) {

        Optional<Book> book=bookRepo.findById((long) id);
        if (book.isEmpty()){
            return ResponseEntity.badRequest().body(String.format("Book with this id  : %d not exist",id));
        }
        Book book1=bookRepo.findByTitle(bookDTO.getTitle());
        if (book1!=null){
            return ResponseEntity.badRequest().body("Book with this title is already exist");
        }
        book.get().setPublicationYear(bookDTO.getPublicationYear());
        book.get().setTitle(bookDTO.getTitle());
        book.get().setAuthor(bookDTO.getAuthor());
        bookRepo.save(book.get());
        return ResponseEntity.ok("Book Updated Successfully");
    }
    @Override
    @Transactional
    public ResponseEntity<String> deleteBook(int id) {
        Optional<Book> book=bookRepo.findById((long) id);
        if (book.isEmpty()){
            return ResponseEntity.badRequest().body(String.format("Book with this id  : %d not exist",id));
        }
        bookRepo.deleteById((long)id);
        return ResponseEntity.ok("Book Delete Successfully");
    }
}
