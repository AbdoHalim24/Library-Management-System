package com.AbdoHalim.LibraryManagementSystem.Service;

import com.AbdoHalim.LibraryManagementSystem.DTO.PatronDTO;
import com.AbdoHalim.LibraryManagementSystem.Entity.Patron;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatronService {
    ResponseEntity<List<Patron>> retrieveAllPatrons();

    ResponseEntity<Patron> retrievePatron(int id);

    ResponseEntity<String> addPatron(PatronDTO patronDTO);

    ResponseEntity<String> updatePatron(PatronDTO patronDTO, int id);

    ResponseEntity<String> deletePatron(int id);
}
