package com.example.SpringBootDTOService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;

    @NotEmpty(message = "User first name can not be null or empty")
    private String user_name;

    @NotEmpty(message = "User mobile no. can not be null or empty")
    private String mobile_no;

    @NotEmpty(message = "User email can not be null or empty")
    @Email(message = "User Email Address should be valid")
    private String emailId;

    private String city;

    private String password;




}
