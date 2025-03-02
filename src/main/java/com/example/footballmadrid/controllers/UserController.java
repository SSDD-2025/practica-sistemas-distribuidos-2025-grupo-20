package com.example.footballmadrid.controllers;

import com.example.footballmadrid.models.UserModel;
import com.example.footballmadrid.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/login")
    public ModelAndView login(Map<String,Object> model){


        model.put("title","login");

        return new ModelAndView("login",model);
    }

    @PostMapping(value= "/login",params = {"username", "password"})
    public ModelAndView menu(@RequestParam String username,@RequestParam String password,Map<String,Object> model){

        if(userService.login(username,password)){

            model.put("title","login");
            model.put("userModel",userService.findByUsername(username));

            return new  ModelAndView("menu",model);
        }
        model.put("message","login failed try again");
        return new ModelAndView("login",model);
    }


    @GetMapping
    public ModelAndView findUsers(Map<String, Object> model) {

        List users = userService.findAll();
        model.put("users", users);
        model.put("title", "<Users>");
        return new ModelAndView("index", model);
    }

    @GetMapping("accountSettings")
    public ModelAndView accountSettings(Map<String, Object> model) {

        model.put("title", "accountSettings");

        return new ModelAndView("accountSettings", model);
    }
    @GetMapping("user/games")
    public ModelAndView games(Map<String, Object> model) {

        model.put("title", "games");


        UserModel userModel = (UserModel) model.get("userModel");

        model.put("gameModels",userModel.getGameModel());


        return new ModelAndView("gameFinder", model);
    }
    @GetMapping(value = "/signUp")
    public ModelAndView getSignUp(Map<String, Object> model) {

        return new ModelAndView("signUp",model);
    }



    @PostMapping(value = "/signUp", params = {"username", "password"})
    public ModelAndView signUp(@RequestParam String username, @RequestParam String password, Map<String,Object> model) {
        if (userService.createUser(username, password)!=null) {
            model.put("message","signUp successful");
            return new ModelAndView("login",model);
        } else {
            model.put("message","signUp failed, username already in use");
            return new ModelAndView("signUp", model);

        }

    }


    /*

    @GetMapping("/{id}")
    public UserModel findById(@PathVariable long id) {
        return userService.findById(id);
    }
    @PutMapping("/{id}")
    public UserModel updateUser(@PathVariable long id, @RequestBody String username) {
    //    "http://localhost:8080/user/1?username=changed"
    //  example of use
        userService.editUserName(id, username);
        return userService.findById(id);

    }
     */


}
