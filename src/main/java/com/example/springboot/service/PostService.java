package com.example.springboot.service;

import com.example.springboot.entities.PostModel;
import com.example.springboot.entities.User;
import com.example.springboot.repositary.PostRepositary;
import com.example.springboot.repositary.UserRepositary;
import com.example.springboot.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class PostService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PostRepositary postRepositary;

    @Autowired
    private UserRepositary userRepositary;

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

    public String feedpost(PostModel postModel) {
        String email=getuserEmail();
        User user=userRepositary.findByEmail(email);
        postModel.setUser(user);
        postRepositary.save(postModel);
        return  "Posted Successfully";
    }
}
