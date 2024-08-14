package com.AbdoHalim.LibraryManagementSystem.Controller;

import com.AbdoHalim.LibraryManagementSystem.DTO.PatronDTO;
import com.AbdoHalim.LibraryManagementSystem.Entity.Patron;
import com.AbdoHalim.LibraryManagementSystem.Service.PatronService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patrons")
public class PatronController {
    private final PatronService patronService;
    @GetMapping("")
    public ResponseEntity<List<Patron>> RetrieveAllPatrons(){
        return patronService.retrieveAllPatrons();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patron> RetrievePatronByID(@PathVariable int id){
        return patronService.retrievePatron(id);
    }
    @PostMapping("")
    public ResponseEntity<String> addPatron(@RequestBody PatronDTO patronDTO){
        return patronService.addPatron(patronDTO);

    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatron(@RequestBody PatronDTO patronDTO,@PathVariable int id){
        return patronService.updatePatron(patronDTO,id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deletePatron(@PathVariable int id){
        return patronService.deletePatron(id);
    }
}
