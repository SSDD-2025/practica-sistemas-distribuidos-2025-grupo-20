package com.example.footballmadrid;

import com.example.footballmadrid.models.UserModel;
import com.example.footballmadrid.repositories.UserRepository;
import com.example.footballmadrid.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitDB {
@Autowired
UserRepository userRepository;
@Autowired
UserService userService;

@PostConstruct
public void initDB() {
    userRepository.deleteAll();

    if (!isTestingEnviroment()) {

        userRepository.save(new UserModel("jose", "josepass"));
        userRepository.save(new UserModel("juan", "juanpass"));
        userRepository.save(new UserModel("luis", "luispass"));
        userRepository.save(new UserModel("pepe", "pepepass"));



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
