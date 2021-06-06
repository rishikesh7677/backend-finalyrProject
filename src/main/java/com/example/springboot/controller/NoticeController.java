package com.example.springboot.controller;

import com.example.springboot.entities.Notice;
import com.example.springboot.response.MessageResponse;
import com.example.springboot.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/notice/post")
    public MessageResponse newnotice(@RequestBody Notice notice){
        return  new MessageResponse(noticeService.newnotice(notice));
    }

    @GetMapping("/notice/all")
    public ArrayList<Notice> allnotice(){
        return  noticeService.allnotice();
    }

    @GetMapping("/notice/{notice_id}")
    public Notice getbyid(@PathVariable(value = "notice_id") Integer notice_id){
        return noticeService.getbyid(notice_id);
    }

    @DeleteMapping("/notice/delete/{notice_id}")
    public MessageResponse delnotice(@PathVariable(value = "notice_id") Integer notice_id){

        return  new MessageResponse(noticeService.delnotice(notice_id));
    }


}
