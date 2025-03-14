package com.example.SpringBootDTOService.service;

import com.example.SpringBootDTOService.dto.UserDTO;
import com.example.SpringBootDTOService.entity.User;
import com.example.SpringBootDTOService.exception.EmailAlreadyExistsException;
import com.example.SpringBootDTOService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplUsingOptional implements UserServiceUsingOptional{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        Optional<User> optionalUser = userRepository.findByEmailId(userDTO.getEmailId());

        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email already exist for user");
        }

        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);
        UserDTO savedUserDTO = modelMapper.map(savedUser, UserDTO.class);
        return savedUserDTO;
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
