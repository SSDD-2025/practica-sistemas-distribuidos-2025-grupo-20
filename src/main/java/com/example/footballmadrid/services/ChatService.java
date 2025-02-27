package com.example.footballmadrid.services;

import com.example.footballmadrid.models.ChatModel;
import com.example.footballmadrid.repositories.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    public ChatService() {}
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public ChatModel save(ChatModel chatModel) {
        return chatRepository.save(chatModel);
    }
}
