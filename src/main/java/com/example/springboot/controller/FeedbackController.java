package com.example.springboot.controller;

import com.example.springboot.entities.Feedback;
import com.example.springboot.repositary.FeedbackRepositary;
import com.example.springboot.response.MessageResponse;
import com.example.springboot.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class FeedbackController {


    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback/post")
    public MessageResponse feedback(@RequestBody Feedback feedback){
        return new MessageResponse(feedbackService.feedback(feedback));
    }
}
