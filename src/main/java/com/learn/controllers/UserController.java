package com.learn.controllers;

import com.learn.models.User;
import com.learn.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
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

    //When CSRF protection is enabled in Spring Security, it blocks all non-GET requests (like POST, PUT, DELETE) unless those requests include a valid CSRF token.
    //This mechanism prevents malicious websites from tricking your authenticated users into unknowingly sending unwanted requests.
    //The purpose of this method below is to expose the CSRF token to the client (e.g., Postman) so that the client can include
    //this token when making state-changing requests like POST, PUT, or DELETE.

    // Method for generating csrf token
    @GetMapping("/csrf_token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("_csrf");
    }
    //Save/add user
    @PostMapping("/")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
}
