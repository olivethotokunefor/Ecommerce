package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Models.User;
import com.example.Ecommerce.Repositories.ItemRepository;
import com.example.Ecommerce.Repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tcontroller {


    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public Tcontroller(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }


    @PostMapping("/adminsss")
    public void createAdmin(@RequestBody AdminController.CreateUserRequest request) {
        User admin = new User();
        admin.setFirstname(request.firstname());
        admin.setEmail(request.email());
        admin.setLastname(request.lastname());
        admin.setPassword(new BCryptPasswordEncoder().encode(request.password()));
        admin.setAuthority("ADMIN");
        userRepository.save(admin);
    }
}
