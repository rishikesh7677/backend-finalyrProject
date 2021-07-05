package com.example.springboot.repositary;

import com.example.springboot.entities.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepositary extends CrudRepository<Feedback,Integer> {
}
