package com.example.footballmadrid.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "userModel")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy ="userModel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentModel> commentModel;

    @ManyToMany()
    @JoinTable(
            name = "user_pitch",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "pitch_id")}
    )
    private List<PitchModel> pitchModel;

    @ManyToMany(mappedBy = "userModel")
    private List<GameModel>  gameModel;

    @ManyToOne
    @JoinColumn(name = "chatModel_id")
    private ChatModel chatModel;

    public List<GameModel> getGameModel() {
        return gameModel;
    }

    public void setGameModel(List<GameModel> gameModel) {
        this.gameModel = gameModel;
    }

    public ChatModel getChatModel() {
        return chatModel;
    }

    public void setChatModel(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public List<MessageModel> getMessageModel() {
        return messageModel;
    }

    public void setMessageModel(List<MessageModel> messageModel) {
        this.messageModel = messageModel;
    }

    @OneToMany(mappedBy = "userModel")
    private List<MessageModel> messageModel;

    public List<CommentModel> getCommentModel() {
        return commentModel;
    }

    public void setCommentModel(List<CommentModel> commentModel) {
        this.commentModel = commentModel;
    }

    public List<PitchModel> getPitchModel() {
        return pitchModel;
    }

    public void setPitchModel(List<PitchModel> pitchModel) {
        this.pitchModel = pitchModel;
    }

    public UserModel() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
