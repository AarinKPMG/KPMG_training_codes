package com.example.SpringMVCBoot.controller;

import com.example.SpringMVCBoot.beans.Login;
import com.example.SpringMVCBoot.beans.User;
import com.example.SpringMVCBoot.exceptions.ApplicationException;
import com.example.SpringMVCBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login) throws ApplicationException {

        User user = userRepository.searchByName(login.getUsername());

        if(user==null){
            throw new ApplicationException("User Not Found !");
        }

        return "search";
    }

}
