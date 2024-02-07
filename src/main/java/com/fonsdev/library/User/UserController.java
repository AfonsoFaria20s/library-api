package com.fonsdev.library.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
    @GetMapping("/byName")
    public @ResponseBody List<User> findByName(
            @RequestParam("name") String name
    ) {
        return userRepository.findAllByName(name);
    }

    // Find user by id
    @GetMapping("/byId")
    public @ResponseBody Optional<User> findById(
            @RequestParam("id") int id
    ) {
        return userRepository.findById(id);
    }

    // Add new user
    @PostMapping("/add")
    public @ResponseBody String addUser(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam int age
    ) {

        if(userRepository.findByEmail(email).isEmpty()) {
            User newUser = new User(name, email, password,age);
            userRepository.save(newUser);
            return "User added successfully";
        } else {
            return "Email is already taken";
        }
    }

    //Delete user by email
    @DeleteMapping("/deleteByEmail")
    public String deleteByEmail(
            @RequestParam String email
    ) {
        return "User with email \""+email+"\" deleted successfully.";
    }

    //Delete user by id
    @DeleteMapping("/deleteById")
    public String deleteById(
            @RequestParam int id
    ) {
        return "User with id \""+id+"\" was deleted successfully";
    }

    //Update user's name by id
    @PutMapping("updateUserName/{id}")
    public @ResponseBody String updateUserNameById(
            @PathVariable(value = "id") int id,
            @RequestParam(value = "name") String name
    ) {
        Optional<User> userOpt = userRepository.findById(id);
        User user = userOpt.get();

        user.setName(name);
        userRepository.save(user);

        return "User saved successfully\nNew Information:\n"+user.toString();
    }
    //Update user's password by id
    @PutMapping("updateUserName/{id}")
    public @ResponseBody String updateUserPassById(
            @PathVariable(value = "id") int id,
            @RequestParam(value = "password") String password
    ) {
        Optional<User> userOpt = userRepository.findById(id);
        User user = userOpt.get();

        user.setPassword(password);
        userRepository.save(user);

        return "User saved successfully\nNew Information:\n"+ user;
    }
}
