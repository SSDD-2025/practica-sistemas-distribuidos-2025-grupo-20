package com.example.footballmadrid.repositories;

import com.example.footballmadrid.models.GameModel;
import com.example.footballmadrid.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameModel, String> {

    //public GameModel addUser(UserModel userModel);

}
