package com.example.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment_tabel")
@Data
@Getter
@Setter
@AllArgsConstructor
public class Comments_tab {
    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "comment_id")
    private int comment_id;
    @Column(columnDefinition="text")
    private  String cotent;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "postid")
    private PostModel postModel;
    private LocalDateTime dateTime= LocalDateTime.now();

    }
