package com.example.footballmadrid.DTO;

import com.example.footballmadrid.models.GameModel;

public class gameDTO {
    Long gameID;

    public gameDTO(GameModel gameModel){
        this.gameID = Long.valueOf(gameModel.getId());


    }

}
