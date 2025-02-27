package com.example.footballmadrid.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CommentModel {
    @Id
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "userModel_id")
    private UserModel userModel;

    @ManyToOne()
    @JoinColumn(name = "pitchModel_id")
    private PitchModel pitchModel;

    public CommentModel() {

    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public PitchModel getPitchModel() {
        return pitchModel;
    }

    public void setPitchModel(PitchModel pitchModel) {
        this.pitchModel = pitchModel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
