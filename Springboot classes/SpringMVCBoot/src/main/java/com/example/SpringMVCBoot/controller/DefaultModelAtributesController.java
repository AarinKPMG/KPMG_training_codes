package com.example.SpringMVCBoot.controller;

import com.example.SpringMVCBoot.beans.Login;
import com.example.SpringMVCBoot.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class DefaultModelAtributesController {

    @ModelAttribute("newuser")
    public User defaultUserData(){
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> getGenderItems(){
        return Arrays.asList(new String[]{"Male","Female","Other"});
    }

    @ModelAttribute("login")
    public Login defaultLoginData(){
        return new Login();
    }
}
