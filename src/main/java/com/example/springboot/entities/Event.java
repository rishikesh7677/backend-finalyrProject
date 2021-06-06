package com.example.springboot.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.spi.LocaleServiceProvider;

@Entity
@Table(name = "event")
@Data
@Getter
@Setter
public class Event {

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "event_id")
    private int event_id;
    //@Column(nullable = false)
    private  String  title;
    @Column(columnDefinition = "text")
    private String Description;
    //@Column(nullable = false)
    private  String Link;
    private  String image;
    private LocalDateTime eventdate;
    private  LocalDateTime created_at=LocalDateTime.now();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id")
    private  User user;
    private int likecount;

    public Event() {
    }

    public Event(String title, String description, String link, String image, LocalDateTime eventdate, LocalDateTime created_at, User user, int likecount) {
        this.title = title;
        Description = description;
        Link = link;
        this.image = image;
        this.eventdate = eventdate;
        this.created_at = created_at;
        this.user = user;
        this.likecount = likecount;
    }
}
