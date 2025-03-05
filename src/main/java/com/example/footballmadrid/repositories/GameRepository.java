package com.example.footballmadrid.repositories;

import com.example.footballmadrid.models.GameModel;
import com.example.footballmadrid.models.PitchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<GameModel, String> {

    //public GameModel addUser(UserModel userModel);
    public List<GameModel> findAllByPitchModel(PitchModel pitchModel);

    public Optional<GameModel> findById(String id);
    
    
}
