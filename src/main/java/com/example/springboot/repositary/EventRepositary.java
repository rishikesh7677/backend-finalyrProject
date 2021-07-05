package com.example.springboot.repositary;

import com.example.springboot.entities.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Optional;

public interface EventRepositary extends CrudRepository<Event,Integer> {

    @Query("Select row from Event row where row.event_id = :eid")
    Event findByid(@Param("eid") Integer eid);

    @Query("Select row from Event row where row.Is_approved = :eid")
    ArrayList<Event> findAllbyapp(@Param("eid") Boolean eid);
}
