package com.example.springboot.service;

import com.example.springboot.entities.Event;
import com.example.springboot.repositary.EventRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepositary eventRepositary;
    public String createevent(Event event) {
        eventRepositary.save(event);
        return  "Event Posted Succesfully";
    }

    
}
