package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @RequestMapping("/")
    public String index(){return "Welcom to api check";}
}
