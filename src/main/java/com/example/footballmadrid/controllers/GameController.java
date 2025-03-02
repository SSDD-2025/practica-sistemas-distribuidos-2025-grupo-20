package com.example.footballmadrid.controllers;


import com.example.footballmadrid.models.GameModel;
import com.example.footballmadrid.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    GameService gameService;

@GetMapping
public ModelAndView findGames(Map<String,Object> model){
    model.put("title","games");
    model.put("gameModel",gameService.findAll());


    return new  ModelAndView("games",model);
}



}
