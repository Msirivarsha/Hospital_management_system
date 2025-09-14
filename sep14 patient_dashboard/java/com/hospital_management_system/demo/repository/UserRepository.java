package com.hospital_management_system.demo.repository;

import com.hospital_management_system.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    
    // Optional: find User by username for authentication
    User findByUsername(String username);
}
