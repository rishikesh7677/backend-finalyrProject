package com.example.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "oppurtinity")
@Data
@Getter
@Setter
@AllArgsConstructor

public class Oppurtinity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "suggestion_id")
    private int suggestionid;
    private String title;
    @Column(columnDefinition="text")
    private  String description;
    @Column(columnDefinition="text")
    private String image;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id" , referencedColumnName = "email")
    private  User user;
    private LocalDateTime createdat=LocalDateTime.now();
    private Boolean Is_approved=false;
}
