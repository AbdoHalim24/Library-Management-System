package com.AbdoHalim.LibraryManagementSystem.DTO;

import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class LoginDTO {
    private String userName;
    private String password;
}
