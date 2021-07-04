package com.example.springboot.controller;


import com.example.springboot.entities.User;
import com.example.springboot.request.HitkLogin;
import com.example.springboot.response.MessageResponse;
import com.example.springboot.response.TokenResponse;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

        @GetMapping("/getuser/{id}")
        public User getBy(@PathVariable(value = "id") String id){
            return  userservice.getBy(id);
        }
        @PostMapping("/auth/register")
        public MessageResponse create(@RequestBody User aduser){
            return new MessageResponse( userservice.create(aduser));
        }
        @PutMapping("/updateUser")
        public  String update(@RequestBody User aduser){
            return userservice.create(aduser);
        }
        @PostMapping("/user/login")
        public TokenResponse loginCompany(@RequestBody HitkLogin userlogin) throws Exception {
            return userservice.login(userlogin);
        }
    }


