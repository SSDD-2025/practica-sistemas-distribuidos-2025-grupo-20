package com.example.footballmadrid.controllers;

import com.example.footballmadrid.models.UserModel;
import com.example.footballmadrid.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;




    @GetMapping("/users")
    public ModelAndView findUsers(Map<String, Object> model) {

        List users = userService.findAll();
        model.put("users", users);
        model.put("title", "<Users>");
        return new ModelAndView("index", model);
    }
    @RequestMapping("/user")
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


}
