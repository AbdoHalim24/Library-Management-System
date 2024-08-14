package com.AbdoHalim.LibraryManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {
    private String userName;
    private String password;


}
