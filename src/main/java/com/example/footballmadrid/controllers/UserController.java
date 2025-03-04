package com.example.footballmadrid.controllers;

import com.example.footballmadrid.models.UserModel;
import com.example.footballmadrid.repositories.UserRepository;
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
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/login")
    public ModelAndView login(Map<String,Object> model){


        model.put("title","login");

        return new ModelAndView("login",model);
    }
    @PostMapping(value= "/login",params = {"username", "password"})
    public ModelAndView menu(@RequestParam String username,@RequestParam String password,Map<String,Object> model){

        if(userService.login(username,password)){

            model.put("title","login");
            model.put("id",userService.findByUsername(username).getId());
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
    @GetMapping("user/accountSettings")
    public ModelAndView accountSettings(@RequestParam Long id, Map<String, Object> model) {

        model.put("id",id);
        model.put("userModel",userService.findById(id) );
        model.put("title", "accountSettings");

        return new ModelAndView("accountSettings", model);
    }
    @PostMapping(value = "user/accountSettings", params = {"id"})
    public ModelAndView PostAccountSettings(@RequestParam Long id, Map<String, Object> model) {
        model.put("id", id);
        model.put("userModel",userService.findById(id) );
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

    @PostMapping(value = "/user/changeUsernameMenu", params = {"id"})
    public ModelAndView PostChangeUsernameMenu(@RequestParam Long id, Map<String, Object> model) {
        model.put("id",id);
        model.put("userModel",userService.findById(id));
        model.put("title", "changeUsername");

        return new ModelAndView("changeUsername", model);
    }
    @PostMapping(value = "/user/changeUsername", params = {"id","username"})
    public ModelAndView PostChangeUsername(@RequestParam Long id, @RequestParam String username, Map<String, Object> model) {


        if(userRepository.findByUsername(username)!=null) {
            model.put("id",id);
            model.put("userModel",userService.findById(id));
            model.put("message","username already in use");
            return new ModelAndView("changeUsername",model);
        }
        UserModel userModel = userService.findById(id);
        userModel.setUsername(username);
        userService.save(userModel);
        model.put("id",id);
        model.put("title", "changeUsername");
        model.put("message","username successfully changed");
        model.put("userModel",userModel);
        return new ModelAndView("menu", model);
    }

    @GetMapping(value="/user/changePassword")
    public ModelAndView changePassword(@RequestParam Long id, Map<String, Object> model) {
        model.put("id",id);
        model.put("userModel",userService.findById(id));
        return new ModelAndView("changePassword",model);
    }

    @PostMapping(value="/user/changePassword", params = {"id", "newPassword"})
    public ModelAndView PostChangePassword(@RequestParam Long id, @RequestParam String newPassword, Map<String,Object> model) {
        UserModel userModel = userService.findById(id);
        userModel.setPassword(newPassword);

        model.put("userModel",userService.save(userModel));
        model.put("id", id);

        return new ModelAndView("menu",model);

    }
    @GetMapping("/error")
    public ModelAndView error(Map<String, Object> model) {

        return new ModelAndView("error",model);
    }

}
