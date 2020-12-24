package com.adelinasprojects.secretSanta.controllers;

import com.adelinasprojects.secretSanta.dto.UserDTO;
import com.adelinasprojects.secretSanta.entities.User;
import com.adelinasprojects.secretSanta.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signup")
    public void createAccount(@RequestBody User user){
        userService.createAccount(user);
    }

    @PostMapping("login")
    public String login(@RequestBody UserDTO userDTO){
        if(userService.login(userDTO)){
            return "Logging in successfully";
        };

        return "Username or password invalid. Please try again. ";
    }
}
