package com.example.testcases.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="ITEM")
public class Item {

    @Id
    private int id ;
    private String name ;
    private int price ;
    private int quantity ;
    @Transient
    private int value ;

    public Item(int id , String name , int price ,int quantity){
        this.id = id ;
        this.name = name ;
        this.price = price ;
        this.quantity = quantity ;
    }
}
