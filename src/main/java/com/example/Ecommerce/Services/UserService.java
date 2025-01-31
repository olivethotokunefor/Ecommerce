package com.example.Ecommerce.Services;

import com.example.Ecommerce.Models.User;
import com.example.Ecommerce.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class  UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String firstname) throws UsernameNotFoundException {
        return userRepository.findByFirstname(firstname);
    }


    public String create(User user){
        userRepository.save(user);
        return "create successfully";
    }
}
