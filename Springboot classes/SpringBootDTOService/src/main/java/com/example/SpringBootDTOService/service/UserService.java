package com.example.SpringBootDTOService.service;

import com.example.SpringBootDTOService.entity.User;

import java.util.*;

public interface UserService {

    public List<User> getAllUsersList();

    public void save(User user);

    public User findById(Integer id);

    public void delete(User user);
}
