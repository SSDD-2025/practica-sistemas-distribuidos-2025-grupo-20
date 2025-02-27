package com.example.footballmadrid.services;

import com.example.footballmadrid.models.UserModel;
import com.example.footballmadrid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    //constructors
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserService() {}
    //constructors


    //methods
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }
    public int delete(Long id) {
        try {
            userRepository.deleteById(id);
            return 0;
        }
        catch (Exception e) {
            return 0;
        }

    }
    public int editUserName(Long id,String name){

        //edit username given an id, fails if the name is already in use
        /*
        * return map
        * 0 -> everything okay
        * 1 -> the name you are trying to change to is already in use
        * 2 -> the id you are trying to change does not exist
        *
        ** */

        try{
            userRepository.findByUsername(name);
            System.err.println("Name already in use");
            return 1;
        }catch (Exception e){
            try{
                userRepository.editUsernameById(id,name);
                return 0;
            }
            catch(Exception e1) {
                return 2;
            }
        }



    }


}
