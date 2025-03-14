package com.tutorials.tutorialBackend.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tutorials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="published")
    private boolean published;

    public Tutorial(String title , String desc, boolean publ){
        this.title = title;
        this.description = desc;
        this.published = publ;
    }

}
