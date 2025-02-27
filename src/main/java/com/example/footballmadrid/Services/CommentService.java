package com.example.footballmadrid.Services;

import com.example.footballmadrid.Repositories.ChatRepository;
import com.example.footballmadrid.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

}
