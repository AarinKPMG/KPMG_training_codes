package com.example.address_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id ;

    @Column(name="city")
    private String city ;

    @Column(name = "state")
    private String state ;


}
