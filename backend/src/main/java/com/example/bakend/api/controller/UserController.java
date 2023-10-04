package com.example.bakend.api.controller;

import com.example.bakend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.bakend.api.model.User;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;
    @GetMapping("/user")
    public User getUser() {
        return userService.getUser();
    }
}
