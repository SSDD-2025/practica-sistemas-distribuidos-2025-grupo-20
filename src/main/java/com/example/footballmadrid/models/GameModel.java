package com.example.footballmadrid.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "gameModel")
public class GameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String startTime;

    @ManyToOne
    @JoinColumn(name = "pitchModel_id")
    private PitchModel pitchModel;

    @ManyToMany
    @JoinTable(
            name = "game_user",
            joinColumns = {@JoinColumn(name = "game_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private Set<UserModel> userModel;

    public GameModel() {

    }
    public GameModel(String startTime, PitchModel pitchModel) {
        this.pitchModel = pitchModel;
        this.startTime = startTime;
    }

    public void addUser(UserModel userModel) {
            this.userModel.add(userModel);
    }

    //getters and setters

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PitchModel getPitchModel() {
        return pitchModel;
    }

    public void setPitchModel(PitchModel pitchModel) {
        this.pitchModel = pitchModel;
    }

    public Set<UserModel> getUserModel() {
        return userModel;
    }

    public void setUserModel(Set<UserModel> userModel) {
        this.userModel = userModel;
    }
}
