package com.tutorials.tutorialBackend.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tutorials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
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


    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST , CascadeType.MERGE
    })
    @JoinTable(
        name = "tutorial_tags" ,
        joinColumns = {
            @JoinColumn(name = "tutorials_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name="tags_id")
        }
    )
    private Set<Tag> tags = new HashSet<>();

    public void addTag(Tag tag){
        this.tags.add(tag);
        tag.getTutorials().add(this);
    }

    public void removeTag(long tagId){
        Tag tag = this.tags.stream().filter( t-> t.getId()==tagId ).findFirst().orElse(null);
        if(tag!=null){
            this.tags.remove(tag);
            tag.getTutorials().remove(this);
        }
    }

    public Tutorial(String title , String desc, boolean publ){
        this.title = title;
        this.description = desc;
        this.published = publ;
    }

}
