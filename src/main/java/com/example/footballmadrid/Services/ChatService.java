package com.example.footballmadrid.Services;

import com.example.footballmadrid.Models.ChatModel;
import com.example.footballmadrid.Repositories.ChatRepository;
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
