package com.example.footballmadrid.Models;

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
