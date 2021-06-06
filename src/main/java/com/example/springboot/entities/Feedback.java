package com.example.springboot.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback")
@Data
@Getter
@Setter
@AllArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "query_id")
    private int query_id;
    @Column(columnDefinition="text")
    private  String cotent;
    private LocalDateTime created_at=LocalDateTime.now();
    @Column(columnDefinition = "text")
    private String response;
    private LocalDateTime response_at;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "creator_id")
    private User user;
}
