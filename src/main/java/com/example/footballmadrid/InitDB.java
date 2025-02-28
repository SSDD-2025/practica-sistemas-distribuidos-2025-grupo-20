package com.example.footballmadrid;

import com.example.footballmadrid.models.GameModel;
import com.example.footballmadrid.models.PitchModel;
import com.example.footballmadrid.models.UserModel;
import com.example.footballmadrid.repositories.GameRepository;
import com.example.footballmadrid.repositories.PitchRepository;
import com.example.footballmadrid.repositories.UserRepository;
import com.example.footballmadrid.services.GameService;
import com.example.footballmadrid.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitDB {
@Autowired
UserRepository userRepository;
@Autowired
UserService userService;

@Autowired
GameRepository gameRepository;
@Autowired
PitchRepository pitchRepository;
    @Autowired
    private GameService gameService;

    @PostConstruct
public void initDB() {
    userRepository.deleteAll();
    gameRepository.deleteAll();
    pitchRepository.deleteAll();

    if (!isTestingEnviroment()) {
        UserModel um1 =new UserModel("jose", "josepass");
        userRepository.save(um1);

        UserModel um2 =new UserModel("juan", "juanpass");
        userRepository.save(um2);

        UserModel um3 =new UserModel("luis", "luispass");
        userRepository.save(um3);

        UserModel um4 =new UserModel("pepe", "pepepass");
        userRepository.save(um4);



        PitchModel pitchModel = new PitchModel("getafe_fc","getafe","10:00 - 00:00");
        pitchRepository.save(pitchModel);
        GameModel gm1 =new GameModel("game1","10:00", pitchModel);
        gameRepository.save(gm1);
        GameModel gm2 =new GameModel("game2","12:00", pitchModel);
        gameRepository.save(gm2);
        GameModel gm3 =new GameModel("game3","14:00", pitchModel);
        gameRepository.save(gm3);
        GameModel gm4 =new GameModel("game4","16:00", pitchModel);
        gameRepository.save(gm4);



        userService.joinGame(gm1,um1);
        userService.joinGame(gm2,um2);
        userService.joinGame(gm1,um2);




/*
        userService.joinGame(gm2,um4);
        userService.joinGame(gm3,um4);
        userService.joinGame(gm2,um1);
*/





    }
}

    private boolean isTestingEnviroment(){
        try {
            Class.forName("org.junit.jupiter.api.Test");
            System.out.println("TEST ENV");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("PRODUCTION ENV");
            return false;
        }
    }
}
