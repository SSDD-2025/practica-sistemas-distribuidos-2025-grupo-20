package com.example.footballmadrid.Services;

import com.example.footballmadrid.Models.GameModel;
import com.example.footballmadrid.Repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
