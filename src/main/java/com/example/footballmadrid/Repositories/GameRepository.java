package com.example.footballmadrid.Repositories;

import com.example.footballmadrid.Models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {
}
