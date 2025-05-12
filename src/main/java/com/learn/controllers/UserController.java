package com.learn.controllers;

import com.learn.models.User;
import com.learn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Only admins can access these APIs

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Get all users
    @GetMapping("/")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    //Get single user
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") String userName){
        return this.userService.getUser(userName);
    }

    //Save/add user
    @PostMapping("/{}")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
}
