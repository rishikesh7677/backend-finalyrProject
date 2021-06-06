package com.example.springboot.service;

import com.example.springboot.entities.Event;
import com.example.springboot.repositary.EventRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EventService {
    @Autowired
    private EventRepositary eventRepositary;
    public String createevent(Event event) {
        eventRepositary.save(event);
        return  "Event Posted Succesfully";
    }


    public ArrayList<Event> getqllevent() {
        return (ArrayList<Event>) eventRepositary.findAll();
    }

    public String updateevent(Integer event_id, Event event) {
        Event event1=eventRepositary.findByid(event_id);
        event1.setEventdate(event.getEventdate());
        event1.setDescription(event.getDescription());
        event1.setImage(event.getImage());
        event1.setTitle(event.getTitle());
        event1.setLink(event.getLink());
        eventRepositary.save(event1);
        return "Update Succesfully";
    }

    public Event geteventbyid(Integer event_id) {
        return eventRepositary.findByid(event_id);
    }

    public String delevent(Integer event_id) {
        eventRepositary.deleteById(event_id);
        return  "deleted Successfully";
    }
}
