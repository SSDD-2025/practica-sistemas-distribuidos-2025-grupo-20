package com.example.footballmadrid.controllers;

import com.example.footballmadrid.models.UserModel;
import com.example.footballmadrid.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserModel> findAll() {
        return userService.findAll();
    }

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

    //ignorar esto me olvide totalmente que no es de esta practica pero se queda para la siguiente :)
}
