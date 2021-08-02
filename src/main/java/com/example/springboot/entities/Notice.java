package com.example.springboot.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Noticetabel")
@Data
@Getter
@Setter

public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Notice_id")
    private int id;
    private String title;
    @Column(columnDefinition="text")
    private String content;
    private String link;
    private LocalDateTime Cdate=LocalDateTime.now();

    public Notice() {
    }

    public Notice(String title, String content, String link) {
        this.title = title;
        this.content = content;
        this.link = link;
    }
}
