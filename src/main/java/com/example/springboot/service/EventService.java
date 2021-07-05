package com.example.springboot.service;

import com.example.springboot.entities.Event;
import com.example.springboot.entities.User;
import com.example.springboot.repositary.EventRepositary;
import com.example.springboot.repositary.UserRepositary;
import com.example.springboot.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Service
public class EventService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private EventRepositary eventRepositary;

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
    public String createevent(Event event) {
        String email=getuserEmail();
        User user=userRepositary.findByEmail(email);
        event.setUser(user);
        eventRepositary.save(event);
        return  "Event Posted Succesfully";
    }


    public ArrayList<Event> getallevent() {
        return (ArrayList<Event>) eventRepositary.findAllbyapp(Boolean.TRUE);
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
