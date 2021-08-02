package com.example.springboot.service;


import com.example.springboot.entities.Event;
import com.example.springboot.entities.Feedback;
import com.example.springboot.entities.User;
import com.example.springboot.repositary.FeedbackRepositary;
import com.example.springboot.repositary.UserRepositary;
import com.example.springboot.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepositary feedbackRepositary;

    @Autowired
    private UserRepositary userRepositary;

    @Autowired
    private JwtUtil jwtUtil;

    public String getuserEmail(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes())
                .getRequest();
        String authorizationHeader = request.getHeader("Authorization");
        String token = null;
        String email = null;
        token = authorizationHeader.substring(7);
        email = jwtUtil.extractUsername(token);
        return email;
    }

    public String feedback(Feedback feedback) {
        String email = getuserEmail();
        User user = userRepositary.findByEmail(email);
        feedback.setUser(user);
        feedbackRepositary.save(feedback);
        return "Feedback Posted";
    }
}
