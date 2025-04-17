package com.example.footballmadrid.DTO;

import com.example.footballmadrid.models.GameModel;

public class GameDTO {
    Long gameID;

    public GameDTO(GameModel gameModel){
        this.gameID = Long.valueOf(gameModel.getId());


    }

}
