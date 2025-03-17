package com.tutorials.tutorialBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tutorial_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TutorialDetails {

    @Id
    private long id ;

    @Column
    private Date createdOn;

    @Column
    private String createdBy;

    @OneToOne(fetch=FetchType.LAZY)
    @MapsId
    @JoinColumn(name="tutorial_id")
    private Tutorial tutorial;
}
