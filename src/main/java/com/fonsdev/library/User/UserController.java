package com.fonsdev.library.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public @ResponseBody List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public @ResponseBody String addUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        User newUser = new User(name, email, age);
        userRepository.save(newUser);
        return "User added successfully";
    }
}
