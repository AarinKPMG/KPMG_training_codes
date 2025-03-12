package com.example.SpringMVCBoot.controller;

import com.example.SpringMVCBoot.beans.Login;
import com.example.SpringMVCBoot.beans.User;
import com.example.SpringMVCBoot.exceptions.LoginFailureException;
import com.example.SpringMVCBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("hplus/rest/loginuser")
    public ResponseEntity loginUser(@RequestBody Login login) throws LoginFailureException {
        System.out.println(login.getUsername() + " : " + login.getPassword() + " has come for login");

        User user = userRepository.searchByName(login.getUsername());

        if( user==null ){
//            return ResponseEntity.status(404).build();
            return new ResponseEntity("User Not Found !", HttpStatus.NOT_FOUND);
        }

        if( user.getUsername().equals(login.getUsername()) &&
            user.getPassword().equals(login.getPassword()) ){
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            throw new LoginFailureException("Invalid User name and password");
        }
    }

}
