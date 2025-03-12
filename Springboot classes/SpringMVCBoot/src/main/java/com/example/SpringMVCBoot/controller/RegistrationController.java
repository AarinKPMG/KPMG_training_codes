package com.example.SpringMVCBoot.controller;

import com.example.SpringMVCBoot.beans.User;
import com.example.SpringMVCBoot.repository.UserRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/registerUser")
    public String registerUser(@Valid @ModelAttribute("newuser") User user,
                               BindingResult result, Model model){

        System.out.println("Registering User");

        if(result.hasErrors()){
            return "register";
        }

        userRepository.save(user);
        model.addAttribute("dataSaved", "User Registered Successfully !");
        return "login";

    }

}


