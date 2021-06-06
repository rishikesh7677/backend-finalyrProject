package com.example.springboot.repositary;

import com.example.springboot.entities.PostModel;
import org.springframework.data.repository.CrudRepository;

public interface PostRepositary extends CrudRepository<PostModel,Integer> {
}
