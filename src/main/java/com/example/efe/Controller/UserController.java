package com.example.efe.Controller;

import com.example.efe.Entity.User;
import com.example.efe.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public List <User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable(value = "id") int userId){
        return userRepository.findById(userId).orElse(null);

    }
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable(value = "id") int userId){
        User updatedUser = userRepository.findById(userId).orElse(null);
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setEmail(user.getEmail());
        return userRepository.save(updatedUser);
    }

    @DeleteMapping("/deletedUser/{id}")
    public String deltedUser(@PathVariable(value = "id") int userId){
        User deletedUser = userRepository.findById(userId).orElse(null);
        this.userRepository.delete(deletedUser);
        return "Users deleted";
    }
}
