package com.example.footballmadrid.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pitchModel")
public class PitchModel {

    private String name;
    private String location;
    private String openTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "pitchModel")
    private List<GameModel> gameModel;


    public PitchModel() {

    }
    public PitchModel(String name, String location, String openTime) {
        this.name = name;
        this.location = location;
        this.openTime = openTime;

    }
    //getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<GameModel> getGameModel() {
        return gameModel;
    }

    public void setGameModel(List<GameModel> gameModel) {
        this.gameModel = gameModel;
    }
}
