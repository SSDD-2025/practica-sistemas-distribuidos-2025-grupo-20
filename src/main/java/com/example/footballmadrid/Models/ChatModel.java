package com.example.footballmadrid.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ChatModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "gameModel_id")
    private GameModel gameModel;

    @OneToMany(mappedBy = "chatModel")
    private List<UserModel> userModel;


    @OneToMany(mappedBy = "chatModel")
    private List<MessageModel> messageModel;


    public ChatModel() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
