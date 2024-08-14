package com.AbdoHalim.LibraryManagementSystem.Service.Iml;

import com.AbdoHalim.LibraryManagementSystem.DTO.PatronDTO;
import com.AbdoHalim.LibraryManagementSystem.Entity.Patron;
import com.AbdoHalim.LibraryManagementSystem.Repository.PatronRepo;
import com.AbdoHalim.LibraryManagementSystem.Service.PatronService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatronServiceImp implements PatronService {
    private final PatronRepo patronRepo;
    @Override
    public ResponseEntity<List<Patron>> retrieveAllPatrons() {
        return ResponseEntity.ok(patronRepo.findAll());
    }

    @Override
    public ResponseEntity<Patron> retrievePatron(int id) {
        Optional<Patron> patron=patronRepo.findById((long)id);
        if (patron.isEmpty()){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(patron.get());
    }

    @Override
    @Transactional
    public ResponseEntity<String> addPatron(PatronDTO patronDTO) {
        if (patronDTO.getName().isEmpty()||patronDTO.getContactInformation().isEmpty()){
            return ResponseEntity.badRequest().body("Enter all fields");
        }
        Patron patron=new Patron();
        patron.setName(patronDTO.getName());
        patron.setContactInformation(patronDTO.getContactInformation());
        patronRepo.save(patron);
        return  ResponseEntity.ok("Patron Added Successfully");
    }

    @Override
    @Transactional
    public ResponseEntity<String> updatePatron(PatronDTO patronDTO, int id) {
        Optional<Patron> patron=patronRepo.findById((long)id);
        if (patron.isEmpty()){
            return ResponseEntity.badRequest().body("Patron with this id not exist");
        }
        patron.get().setContactInformation(patronDTO.getContactInformation());
        patron.get().setName(patronDTO.getName());
        patronRepo.save(patron.get());
        return ResponseEntity.ok("Patron updated Successfully");
    }

    @Override
    @Transactional
    public ResponseEntity<String> deletePatron(int id) {
        Optional<Patron> patron=patronRepo.findById((long)id);
        if (patron.isEmpty()){
            return ResponseEntity.badRequest().body("Patron with this id not exist");
        }
        patronRepo.delete(patron.get());
        return ResponseEntity.ok("Patron Delete Successfully");
    }
}
