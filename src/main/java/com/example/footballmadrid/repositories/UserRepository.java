package com.example.footballmadrid.repositories;

import com.example.footballmadrid.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    public UserModel findById(long id);

    public UserModel findByUsername(String username);



    @Modifying
    @Query("UPDATE UserModel u  SET u.username =:username WHERE u.id = :id")
    public UserModel editUsernameById(long id, String username);

}
