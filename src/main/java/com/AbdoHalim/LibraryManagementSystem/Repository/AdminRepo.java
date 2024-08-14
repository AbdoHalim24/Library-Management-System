package com.AbdoHalim.LibraryManagementSystem.Repository;

import com.AbdoHalim.LibraryManagementSystem.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {
    @Query(name = "Select * from admin where user_name=?1",nativeQuery = true)
    Admin findByUserName(String userName);
}
