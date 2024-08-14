package com.AbdoHalim.LibraryManagementSystem.Controller;

import com.AbdoHalim.LibraryManagementSystem.DTO.AdminDTO;
import com.AbdoHalim.LibraryManagementSystem.DTO.LoginDTO;
import com.AbdoHalim.LibraryManagementSystem.Entity.Admin;
import com.AbdoHalim.LibraryManagementSystem.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

@RestController
@RequestMapping("/public")
@RequiredArgsConstructor
public class PublicController {
    private final AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO){
        return adminService.login(loginDTO);
    }
    @PostMapping("/RegisterAdmin")
    public ResponseEntity<String> addAdmin(@RequestBody AdminDTO adminDto){
        return adminService.addAdmin(adminDto);
    }
}
