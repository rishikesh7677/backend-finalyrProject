package com.example.springboot.repositary;

import com.example.springboot.entities.Event;
import com.example.springboot.entities.PostModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface PostRepositary extends CrudRepository<PostModel,Integer> {

    @Query("Select row from PostModel row where row.Is_approved = :eid")
    ArrayList<PostModel> findAllByapp(@Param("eid") Boolean eid);
}
