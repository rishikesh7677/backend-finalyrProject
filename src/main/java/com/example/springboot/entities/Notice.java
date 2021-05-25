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
    @GeneratedValue(generator = "uuid")
    @Column(name = "user_id")
    private int id;
    private String title;
    private String description;
    private String Source;
    private LocalDateTime Cdate;

    public Notice() {
    }

    public Notice(String title, String description, String source, LocalDateTime cdate) {
        this.title = title;
        this.description = description;
        Source = source;
        Cdate = cdate;
    }
}
