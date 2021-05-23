package com.example.springboot.controller;


import com.example.springboot.entities.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {



        private UserService userservice;

        @Autowired
        public UserController(UserService userservice){
            this.userservice=userservice;

        }


        @RequestMapping("/")
        public String index() {
            return "Greetings from Spring Boot";
        }

       /* @GetMapping("/user/{id}")
        public Optional<User> getBy(@PathVariable(value = "id") int id){
            return  userservice.(id);
        }*/
        @PostMapping("/adduser")
        public  String create(@RequestBody User aduser){
            return userservice.create(aduser);
        }
        @PutMapping("/updateUser")
        public  String update(@RequestBody User aduser){
            return userservice.create(aduser);
        }

    }


