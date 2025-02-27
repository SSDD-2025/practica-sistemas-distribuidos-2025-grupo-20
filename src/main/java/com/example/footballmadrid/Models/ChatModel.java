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

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public List<UserModel> getUserModel() {
        return userModel;
    }

    public void setUserModel(List<UserModel> userModel) {
        this.userModel = userModel;
    }

    public List<MessageModel> getMessageModel() {
        return messageModel;
    }

    public void setMessageModel(List<MessageModel> messageModel) {
        this.messageModel = messageModel;
    }

    public ChatModel() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
