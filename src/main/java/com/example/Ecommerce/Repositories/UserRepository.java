package com.example.Ecommerce.Repositories;

import com.example.Ecommerce.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByRole(String role);
    UserDetails findByFirstname(String firstname);
}