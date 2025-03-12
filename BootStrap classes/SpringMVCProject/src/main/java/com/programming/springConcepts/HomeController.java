package com.programming.springConcepts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePage(){
        System.out.println("Showing Home Page");
        return "index";
    }

}
