package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Models.Item;
import com.example.Ecommerce.Models.User;
import com.example.Ecommerce.Repositories.ItemRepository;
import com.example.Ecommerce.Repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public UserController(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }



    // Retrieve user profile
    @GetMapping("/profile/{id}")
    public User getUserProfile(@PathVariable Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Update user profile
    @PutMapping("/profile/{id}")
    public void updateUserProfile(@PathVariable Integer id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstname(userDetails.getFirstname());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        userRepository.save(user);

    }
    @GetMapping
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
