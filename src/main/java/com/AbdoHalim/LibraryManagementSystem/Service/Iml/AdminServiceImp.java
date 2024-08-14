package com.AbdoHalim.LibraryManagementSystem.Service.Iml;

import com.AbdoHalim.LibraryManagementSystem.DTO.AdminDTO;
import com.AbdoHalim.LibraryManagementSystem.DTO.LoginDTO;
import com.AbdoHalim.LibraryManagementSystem.Entity.Admin;
import com.AbdoHalim.LibraryManagementSystem.Repository.AdminRepo;
import com.AbdoHalim.LibraryManagementSystem.Security.JwtService;
import com.AbdoHalim.LibraryManagementSystem.Service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminServiceImp implements AdminService {
    private final AdminRepo adminRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public ResponseEntity<String> login(LoginDTO loginDTO) {
        Admin admin=adminRepo.findByUserName(loginDTO.getUserName());

        // Check if user exists and credentials are correct
        if (admin == null || !passwordEncoder.matches(loginDTO.getPassword(), admin.getPassword())) {
            // status code with "Bad request" message
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request: Invalid Email or Password");
        }

        try {
            // Authenticate the user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getUserName(),
                            loginDTO.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            // Authentication failed due to reasons other than bad credentials
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
        }

        // User authenticated, generate JWT token
        var jwt = jwtService.generateToken(new CustomUserDetails(admin.getUserName(), admin.getPassword() ));
        return ResponseEntity.ok(jwt);
    }

    @Override
    @Transactional
    public ResponseEntity<String> addAdmin(AdminDTO adminDto) {
        if (adminDto.getUserName().isEmpty() || adminDto.getPassword().isEmpty()){
            return ResponseEntity.badRequest().body("Enter all fields");
        }
        Admin admin=adminRepo.findByUserName(adminDto.getUserName());
        if (admin!=null){
            return ResponseEntity.badRequest().body("UserName Exist");
        }
        Admin admin1=new Admin();
        admin1.setUserName(adminDto.getUserName());
        admin1.setPassword(passwordEncoder.encode(adminDto.getPassword()));
        adminRepo.save(admin1);

        return ResponseEntity.ok("Admin Added successfully");
    }


}
