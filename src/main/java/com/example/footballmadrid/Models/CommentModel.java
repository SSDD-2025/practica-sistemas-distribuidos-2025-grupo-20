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

    public CommentModel() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
