package com.example.bakend.api.service;

import com.example.bakend.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setUserName("johndoe");
        user.setEmail("johndodo@gmail.com");
        user.setPassword("password");
        return user;
    }
}
