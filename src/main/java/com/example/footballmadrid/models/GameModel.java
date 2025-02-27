package com.example.footballmadrid.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "gameModel")
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pitchModel_id")
    private PitchModel pitchModel;

    @ManyToMany
    @JoinTable(
            name = "game_user",
            joinColumns = {@JoinColumn(name = "game_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<UserModel> userModel;


    public ChatModel getChatModel() {
        return chatModel;
    }

    public void setChatModel(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public List<UserModel> getUserModel() {
        return userModel;
    }

    public void setUserModel(List<UserModel> userModel) {
        this.userModel = userModel;
    }

    public PitchModel getPitchModel() {
        return pitchModel;
    }

    public void setPitchModel(PitchModel pitchModel) {
        this.pitchModel = pitchModel;
    }

    @OneToOne(mappedBy = "gameModel")
    private ChatModel chatModel;

    public GameModel() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
