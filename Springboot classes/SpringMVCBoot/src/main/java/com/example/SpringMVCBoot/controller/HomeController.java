package com.example.SpringMVCBoot.controller;

import com.example.SpringMVCBoot.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage(){
        System.out.println("Showing Home Page");
        return "index";
    }

    @GetMapping("/goToSearch")
    public String showSearchPage(){
        System.out.println("user is in search page");
        return "search";

    }

    @GetMapping("/goToRegistration")
    public String showRegistration(){
        System.out.println("user is in register page");
        return "register";
    }

}

