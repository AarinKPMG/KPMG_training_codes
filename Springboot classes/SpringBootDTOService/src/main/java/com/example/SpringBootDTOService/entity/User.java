package com.example.SpringBootDTOService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false, unique = true)
    private String mobile_no;

    @Column(nullable = false, unique = true)
    private String emailId;

    @Column
    private String city;

    @Column
    private String password;

}
