package com.example.springboot.controller;

import com.example.springboot.entities.Event;
import com.example.springboot.response.MessageResponse;
import com.example.springboot.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class EventController {
    @Autowired private EventService eventService;

    @PostMapping("/Create_event")
    public MessageResponse createevent(Event event){

        return  new MessageResponse(eventService.createevent(event));
    }
}
