package com.example.footballmadrid.Models;

import jakarta.persistence.*;

@Entity
public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userModel_id")
    private UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "chatModel_id")
    private ChatModel chatModel;

    public MessageModel() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
