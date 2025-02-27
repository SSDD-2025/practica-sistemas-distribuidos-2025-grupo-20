package com.example.footballmadrid.services;

import com.example.footballmadrid.models.MessageModel;
import com.example.footballmadrid.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    public MessageService(){}
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    public MessageModel save(MessageModel messageModel) {
        return messageRepository.save(messageModel);
    }

}
