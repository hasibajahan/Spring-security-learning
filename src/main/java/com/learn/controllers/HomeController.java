package com.learn.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Both admin and normal users can access these APIs
@RestController
@RequestMapping("/public")
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "this is home page.";
    }
    @GetMapping("/login")
    public String login(){
        return "This is login page.";
    }
    @GetMapping("/about")
    public String register(){
        return "This is about the website.";
    }
}
