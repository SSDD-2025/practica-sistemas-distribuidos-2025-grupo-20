package com.example.footballmadrid.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pitchModel")
public class PitchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "pitchModel")
    private List<CommentModel> commentModel;

    @ManyToMany(mappedBy = "pitchModel")
    private List<UserModel> userModel;

    @OneToMany(mappedBy = "pitchModel")
    private List<GameModel> gameModel;


    public PitchModel() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CommentModel> getCommentModel() {
        return commentModel;
    }

    public void setCommentModel(List<CommentModel> commentModel) {
        this.commentModel = commentModel;
    }

    public List<UserModel> getUserModel() {
        return userModel;
    }

    public void setUserModel(List<UserModel> userModel) {
        this.userModel = userModel;
    }

    public Long getId() {
        return id;
    }
}
