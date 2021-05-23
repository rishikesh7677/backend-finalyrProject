package com.example.springboot.entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Usertabel")
@Data
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "user_id")
    private int id;
    @Column(name="name")
    private String name;
    private int rollnumber;
    private  String email;
    private String stream;
    private int batch;
    private long phonenumber;
    private String password;


    public User() {
    }

    public User(String name, int rollnumber, String email, String stream, int batch, long phonenumber, String password) {
        this.name = name;
        this.rollnumber = rollnumber;
        this.email = email;
        this.stream = stream;
        this.batch = batch;
        this.phonenumber = phonenumber;
        this.password = password;
    }
}
