package com.example.footballmadrid.Services;

import com.example.footballmadrid.Models.CommentModel;
import com.example.footballmadrid.Repositories.ChatRepository;
import com.example.footballmadrid.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public CommentService(){}
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public CommentModel save(CommentModel commentModel){
        return commentRepository.save(commentModel);
    }

}
