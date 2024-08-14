package com.AbdoHalim.LibraryManagementSystem.Service;

import com.AbdoHalim.LibraryManagementSystem.DTO.AdminDTO;
import com.AbdoHalim.LibraryManagementSystem.DTO.LoginDTO;
import com.AbdoHalim.LibraryManagementSystem.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;


public interface AdminService  {

    ResponseEntity<String> login(LoginDTO loginDTO);

    ResponseEntity<String> addAdmin(AdminDTO adminDto);
}
