package com.example.springboot.controller;

import com.example.springboot.entities.Event;
import com.example.springboot.response.MessageResponse;
import com.example.springboot.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class EventController {
    @Autowired private EventService eventService;

    @PostMapping("/Create_event")
    public MessageResponse createevent(@RequestBody Event event){

        return  new MessageResponse(eventService.createevent(event));
    }

    @GetMapping("/event/getall")
    public ArrayList<Event> getallevent(){
        return eventService.getallevent();
    }

    @PutMapping("/updateevent/{event_id}")
    public MessageResponse updateevent(@PathVariable Integer event_id,@RequestBody Event event){
        return  new MessageResponse(eventService.updateevent(event_id,event));

    }
    @GetMapping("/event/get/{event_id}")
    public  Event geteventbyid(@PathVariable Integer event_id){
        return  eventService.geteventbyid(event_id);
    }

    @DeleteMapping("/event/del/{event_id}")
    public MessageResponse delevent(@PathVariable Integer event_id){
        return  new MessageResponse(eventService.delevent(event_id));
    }

}
