package com.fonsdev.library.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/accounts")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public @ResponseBody List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Find users by name
    @GetMapping("/findByName")
    public @ResponseBody List<User> findByName(
            @RequestParam("name") String name
    ) {
        return userRepository.findAllByName(name);
    }

    // Find user by id
    @GetMapping("/findById")
    public @ResponseBody Optional<User> findById(
            @RequestParam("id") int id
    ) {
        return userRepository.findById(id);
    }

    @PostMapping("/add")
    public @ResponseBody String addUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {

        if(userRepository.findByEmail(email).isEmpty()) {
            User newUser = new User(name, email, age);
            userRepository.save(newUser);
            return "User added successfully";
        } else {
            return "Email is already taken";
        }
    }
}
