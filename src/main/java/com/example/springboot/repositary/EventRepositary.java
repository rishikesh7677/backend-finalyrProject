package com.example.springboot.repositary;

import com.example.springboot.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepositary extends CrudRepository<Event,Integer> {
}
