package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Models.User;
import com.example.Ecommerce.Repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    record CreateUserRequest(String firstname, String lastname, String email, String password, String authority){}

    // Retrieve all admins
    @GetMapping("/admins")
    public List<User> getAllAdmins() {
        return userRepository.findByAuthority("ADMIN");
    }

    // Retrieve a specific admin by ID
    @GetMapping("/admins/{id}")
    public User getAdminById(@PathVariable Integer id) {
        User admin = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        if (!"ADMIN".equals(admin.getAuthority())) {
            throw new RuntimeException("User is not an admin");
        }
        return admin;
    }

    // Create a new admin
    @PostMapping("/admins")
    public void createAdmin(@RequestBody AdminController.CreateUserRequest request) {
User admin = new User();
admin.setFirstname(request.firstname());
        admin.setEmail(request.email());
        admin.setLastname(request.lastname());
        admin.setPassword(new BCryptPasswordEncoder().encode(request.password()));
        admin.setAuthority("ADMIN");
        userRepository.save(admin);
    }

    // Update an admin
    @PutMapping("/admins/{id}")
    public void updateAdmin(@PathVariable Integer id, @RequestBody User adminDetails) {
        User admin = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        if (!"ADMIN".equals(admin.getAuthority())) {
            throw new RuntimeException("User is not an admin");
        }
        admin.setFirstname(adminDetails.getFirstname());
        admin.setLastname(adminDetails.getLastname());
        admin.setEmail(adminDetails.getEmail());
        userRepository.save(admin);
    }

    @DeleteMapping("/admins/{id}")
    public void deleteAdmin(@PathVariable Integer id) {
        User admin = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Admin not found"));
        if (!"ADMIN".equals(admin.getAuthority())) {
            throw new RuntimeException("User is not an admin");
        }
        userRepository.deleteById(id);
    }





        @GetMapping("/users")
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }





    @GetMapping("/users/{id}")
        public User getUserById(@PathVariable Integer id) {
            return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        }
    }


