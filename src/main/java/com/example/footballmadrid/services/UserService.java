package com.example.footballmadrid.services;

import com.example.footballmadrid.models.GameModel;
import com.example.footballmadrid.models.UserModel;
import com.example.footballmadrid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private ApplicationArguments applicationArguments;

    //constructors
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserService() {}
    //constructors
    //hola


    //methods
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }



    public UserModel createUser(String username, String password){


        if(userRepository.findByUsername(username)==null){
            return userRepository.save(new UserModel(userRepository.count()+1,username,password));
        }




            return null;
    }


    public boolean login(String username, String password) {
        try{
            if(password.compareTo(userRepository.findByUsername(username).getPassword())==0){
                return true;
            }

        }
        catch(Exception e){
            System.err.println("User not found");
            return false;

        }

        return false;
    }





    public void joinGame(GameModel gameModel, UserModel userModel){

        try {
            userRepository.delete(userModel);
            userModel.getGameModel().add(gameModel);
            //roundabout solution to the duplication problem


            userRepository.save(userModel);
        }catch (Exception e){
            //this code was for a Set instead of the actual implemented List
            System.err.println("duplicated"+e.getMessage());




            userModel.getGameModel().add(gameModel);
            userRepository.save(userModel);
        }

    }


    public void  leaveGame(GameModel gameModel, UserModel userModel){
        try {
            userRepository.delete(userModel);
            userModel.getGameModel().remove(gameModel);
            userRepository.save(userModel);

        }catch (Exception e){
            System.err.println("failed to leave game"+e.getMessage());
        }
    }
    public int delete(Long id) {
        /*
        * if deletion goes wrong return 1
        * else 0
        * */

        try {
            userRepository.deleteById(id);
            return 0;
        }
        catch (Exception e) {
            System.err.println("failed deletion"+e.getMessage());
            return 1;
        }

    }
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }
    public UserModel findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public UserModel findByUsername(String username) {
        return userRepository.findByUsername(username);
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
                System.err.println("id not found");
                return 2;
            }
        }



    }


}
