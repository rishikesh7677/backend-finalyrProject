package com.example.springboot.service;


import com.example.springboot.entities.Notice;
import com.example.springboot.repositary.NoticeRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepositary noticeRepositary;

    public String newnotice(Notice notice) {
        noticeRepositary.save(notice);
        return  "Notice has been Posted";

    }

    public ArrayList<Notice> allnotice() {
        ArrayList<Notice> allnotice= (ArrayList<Notice>) noticeRepositary.findAll();
        return  allnotice;
    }

    public Notice getbyid(Integer noticeid) {
        return noticeRepositary.findByid(noticeid);
    }
}
