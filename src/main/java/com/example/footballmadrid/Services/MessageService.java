package com.example.footballmadrid.Services;

import com.example.footballmadrid.Models.MessageModel;
import com.example.footballmadrid.Repositories.MessageRepository;
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
