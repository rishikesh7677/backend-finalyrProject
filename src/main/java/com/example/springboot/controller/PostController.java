package com.example.springboot.controller;

import com.example.springboot.entities.PostModel;
import com.example.springboot.response.MessageResponse;
import com.example.springboot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {
    @Autowired
    public PostService postService;

    @PostMapping("/feed/post")
    public MessageResponse postfeed(@RequestBody PostModel postModel){
        return  new MessageResponse(postService.feedpost(postModel));
    }
}
