package com.example.SpringBootDTOService.controller;

import com.example.SpringBootDTOService.dto.UserDTO;
import com.example.SpringBootDTOService.entity.User;
import com.example.SpringBootDTOService.service.UserService;
//import jdk.internal.icu.text.UnicodeSet;
import com.example.SpringBootDTOService.service.UserServiceUsingOptional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserServiceUsingOptional userService2;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO){
        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();
        User user = modelMapper.map(userDTO, User.class);
        userService.save(user);
        jsonResponseMap.put("status",1);
        jsonResponseMap.put("message", "Record is saved successfully");
        return new ResponseEntity<>(jsonResponseMap, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> saveUsers(){
        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();
        List<User> listOfUsers = userService.getAllUsersList();
        List<UserDTO> listOfUserDTO = new ArrayList<>();
        if(!listOfUsers.isEmpty()){
            for(User user : listOfUsers){
                listOfUserDTO.add(modelMapper.map(user, UserDTO.class));
            }
            jsonResponseMap.put("status",1);
            jsonResponseMap.put("data", listOfUserDTO);
            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);
        }else{
            jsonResponseMap.clear();
            jsonResponseMap.put("status",0);
            jsonResponseMap.put("data", "Data is not found");
            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();
        User user = userService.findById(id);
        user.setUser_name(userDTO.getUser_name());
        user.setMobile_no(userDTO.getMobile_no());
        user.setEmailId(userDTO.getEmailId());
        user.setCity(userDTO.getCity());
        user.setPassword(userDTO.getPassword());
        userService.save(user);
        jsonResponseMap.put("status",1);
        jsonResponseMap.put("data", userService.findById(id));
        return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();
        try {
            User user = userService.findById(id);
            userService.delete(user);
            jsonResponseMap.put("status", 1);
            jsonResponseMap.put("data", "Record is deleted successfully");
            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);
        } catch (Exception e) {
            jsonResponseMap.put("status", 0);
            jsonResponseMap.put("data", "Data is not found!");
            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
        Map<String, Object> jsonResponseMap = new LinkedHashMap<>();
        try {
            User user = userService.findById(id);
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            jsonResponseMap.put("status", 1);
            jsonResponseMap.put("data", userDTO);
            return new ResponseEntity<>(jsonResponseMap, HttpStatus.OK);
        } catch (Exception e) {
            jsonResponseMap.put("status", 0);
            jsonResponseMap.put("data", "Data is not found!");
            return new ResponseEntity<>(jsonResponseMap, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create2")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user){
        UserDTO savedUser = userService2.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
