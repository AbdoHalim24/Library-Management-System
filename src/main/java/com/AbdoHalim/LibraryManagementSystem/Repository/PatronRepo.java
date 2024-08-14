package com.AbdoHalim.LibraryManagementSystem.Repository;

import com.AbdoHalim.LibraryManagementSystem.Entity.Patron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface PatronRepo extends JpaRepository<Patron,Long> {
}
