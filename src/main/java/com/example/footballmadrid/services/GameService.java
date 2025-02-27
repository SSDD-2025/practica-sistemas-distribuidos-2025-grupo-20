package com.example.footballmadrid.services;

import com.example.footballmadrid.models.GameModel;
import com.example.footballmadrid.models.UserModel;
import com.example.footballmadrid.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public GameService() {}
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameModel save(GameModel gameModel) {
        return gameRepository.save(gameModel);
    }








}
