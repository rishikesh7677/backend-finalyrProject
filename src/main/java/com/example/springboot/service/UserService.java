package com.example.springboot.service;

import com.example.springboot.entities.User;
import com.example.springboot.repositary.UserRepositary;
import com.example.springboot.request.HitkLogin;
import com.example.springboot.response.TokenResponse;
import com.example.springboot.util.JwtUtil;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class UserService implements UserDetailsService {
    private UserRepositary userrepositary;
    PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepositary  userrepositary){
        this.userrepositary=userrepositary;
        this.passwordEncoder= new BCryptPasswordEncoder();

    }
    @Autowired
    private JwtUtil jwtUtil;

    public User getBy(String id)
    {
        User result;
        boolean exist=userrepositary.existsByEmail(id);
        if(!exist){
            throw new IllegalStateException("User does not exist");
        }
        else {
            result = userrepositary.findByEmail(id);
            return result;
        }
    }
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
    public TokenResponse login(HitkLogin userd) throws Exception {
        try {
            User exist = userrepositary.findByEmail(userd.getEmail());
            if(exist==null)
                throw new Exception("Invalid Email or Password");
            Boolean result = passwordEncoder.matches( userd.getPassword(), exist.getPassword());
            if(!result)
                throw new Exception("Invalid Email or Password");
        } catch (Exception ex) {
            throw new Exception("Invalid Email or Password");
        }

        return new TokenResponse( jwtUtil.generateToken(userd.getEmail()),"user" ) ;
    }


    @Override

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User company = userrepositary.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(company.getEmail(), company.getPassword(), new ArrayList<>());
    }
}
