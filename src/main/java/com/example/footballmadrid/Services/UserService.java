package com.example.footballmadrid.Services;

import com.example.footballmadrid.Models.UserModel;
import com.example.footballmadrid.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserService() {}


    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

}
