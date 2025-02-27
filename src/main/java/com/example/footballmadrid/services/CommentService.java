package com.example.footballmadrid.services;

import com.example.footballmadrid.models.CommentModel;
import com.example.footballmadrid.repositories.CommentRepository;
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
