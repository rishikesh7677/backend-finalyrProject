package com.example.springboot.service;

import com.example.springboot.entities.User;
import com.example.springboot.repositary.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    private UserRepositary userrepositary;
    PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepositary  userrepositary){
        this.userrepositary=userrepositary;
        this.passwordEncoder= new BCryptPasswordEncoder();

    }


   /* public Optional<User> getBy(String id)
    {
        Optional<User> result;
        boolean exist=userrepositary.existsByEmail(id);
        if(!exist){
            throw new IllegalStateException("User does not exist");
        }
        else {
            result = userrepositary.findByEmail(id);
            return result;
        }
    }*/
    public String create(User aduser){
        boolean exist=userrepositary.existsByEmail(aduser.getEmail());
        if(exist){
            throw new IllegalStateException("User exist already");
        }

        String password=passwordEncoder.encode(aduser.getPassword());
        aduser.setPassword(password);
        userrepositary.save(aduser);
        return "Registration complete";

    }
    public String update(User aduser){
        boolean exist=userrepositary.existsByEmail(aduser.getEmail());
        if(!exist){
            throw new IllegalStateException("User does not exist");
        }
        userrepositary.save(aduser);
        return "updated";

    }
}
