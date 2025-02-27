package com.example.footballmadrid.Repositories;

import com.example.footballmadrid.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    public UserModel findAllByUsername(String username);
}
