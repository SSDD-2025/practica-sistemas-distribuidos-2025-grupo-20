package com.example.footballmadrid.repositories;

import com.example.footballmadrid.models.GameModel;
import com.example.footballmadrid.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    public UserModel findById(long id);

    public UserModel findByUsername(String username);
    public List<UserModel> findAllByGameModel(GameModel gameModel);



    @Modifying
    @Query("UPDATE UserModel u  SET u.username =:username WHERE u.id = :id")
    public UserModel editUsernameById(long id, String username);

}
