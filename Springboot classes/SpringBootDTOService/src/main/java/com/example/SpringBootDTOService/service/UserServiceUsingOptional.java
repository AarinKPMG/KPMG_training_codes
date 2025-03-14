package com.example.SpringBootDTOService.service;

import com.example.SpringBootDTOService.dto.UserDTO;

import java.util.List;

public interface UserServiceUsingOptional {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    void deleteUser(Long userId);
}
