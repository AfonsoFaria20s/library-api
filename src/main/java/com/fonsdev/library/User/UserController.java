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
    @GetMapping("/find")
    public @ResponseBody List<User> findByName(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email
    ) {
        if(id!=null) {
            return userRepository.findAllById(Collections.singleton(id));
        } else if (name!=null) {
            return userRepository.findAllByName(name);
        } else if(email!=null) {
            return userRepository.findByEmail(email);
        }

        return null;
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

    //Delete user by id
    @DeleteMapping("/deleteById")
    public String deleteById(
            @RequestParam int id
    ) {
        userRepository.deleteById(id);
        return "User with id \""+id+"\" was deleted successfully";
    }

    //Update user's name by id
    @PutMapping("updateUser/{id}")
    public @ResponseBody String updateUserInfoById(
            @PathVariable(value = "id") int id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "password", required = false) String password
    ) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            return "User not found";
        }

        User user = userOpt.get();

        // Update name if provided
        if (name != null) {
            user.setName(name);
        }

        // Update password if provided
        if (password != null) {
            user.setPassword(password);
        }

        userRepository.save(user);

        return "User updated successfully\nNew Information:\n" + user.toString();
    }
}
