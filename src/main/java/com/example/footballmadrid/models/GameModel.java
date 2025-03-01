package com.example.footballmadrid.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "gameModel")
public class GameModel {
    @Id
    private String id;
    private String startTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pitchModel_id")
    private PitchModel pitchModel;

    @ManyToMany(mappedBy = "gameModel", fetch = FetchType.EAGER)
    private List<UserModel> userModel = new LinkedList<>();

    public GameModel() {

    }
    public GameModel(String id,String startTime, PitchModel pitchModel) {
        this.pitchModel = pitchModel;
        this.startTime = startTime;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //getters and setters

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getId() {
        return id;
    }

    public PitchModel getPitchModel() {
        return pitchModel;
    }

    public void setPitchModel(PitchModel pitchModel) {
        this.pitchModel = pitchModel;
    }

    public List<UserModel> getUserModel() {
        return userModel;
    }

    public void setUserModel(List<UserModel> userModel) {
        this.userModel = userModel;
    }
}
