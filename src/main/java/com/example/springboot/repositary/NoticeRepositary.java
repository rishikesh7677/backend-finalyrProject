package com.example.springboot.repositary;

import com.example.springboot.entities.Notice;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface NoticeRepositary extends CrudRepository<Notice,Integer> {

    Notice findByid(Integer integer);
}
