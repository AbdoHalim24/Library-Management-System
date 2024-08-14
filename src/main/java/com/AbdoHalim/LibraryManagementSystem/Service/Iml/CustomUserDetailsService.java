package com.AbdoHalim.LibraryManagementSystem.Service.Iml;

import com.AbdoHalim.LibraryManagementSystem.Entity.Admin;
import com.AbdoHalim.LibraryManagementSystem.Repository.AdminRepo;
import com.AbdoHalim.LibraryManagementSystem.Service.Iml.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AdminRepo adminRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin= adminRepo.findByUserName(username);
        if (admin==null){
            throw  new UsernameNotFoundException("User Not Found");
        }

        return new CustomUserDetails(admin.getUserName(),admin.getPassword());
    }
}
