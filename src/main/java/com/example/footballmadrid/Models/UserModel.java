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





    public UserModel() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
