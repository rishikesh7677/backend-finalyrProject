package com.example.springboot.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "Posttabel")
@Data
@Getter
@Setter
public class PostModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "post_id")
    private int postid;
    private String title;
    @Column(columnDefinition="text")
    private  String cotent;
    private String image;
    private ArrayList<String> comments;
    private  int likes;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id" , referencedColumnName = "email")
    private  User user;
    private LocalDateTime dateTime;

    public PostModel() {
    }

    public PostModel(String title, String cotent, String image, ArrayList<String> comments, int likes, User user, LocalDateTime dateTime) {
        this.title = title;
        this.cotent = cotent;
        this.image = image;
        this.comments = comments;
        this.likes = likes;
        this.user = user;
        this.dateTime = dateTime;
    }
}
