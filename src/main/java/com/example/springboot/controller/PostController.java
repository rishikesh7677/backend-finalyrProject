package com.example.springboot.controller;

import com.example.springboot.entities.PostModel;
import com.example.springboot.response.MessageResponse;
import com.example.springboot.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class PostController {
    @Autowired
    public PostService postService;


    @PostMapping("/feed/post")
    public MessageResponse postfeed(@RequestBody PostModel postModel){
        return  new MessageResponse(postService.feedpost(postModel));
    }

    @GetMapping("/feed/get")
    public ArrayList<PostModel> postModels(){
        return postService.postmodel();
    }
}
