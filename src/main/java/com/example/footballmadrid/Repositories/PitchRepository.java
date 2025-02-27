package com.example.footballmadrid.Repositories;

import com.example.footballmadrid.Models.PitchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitchRepository extends JpaRepository<PitchModel, Integer> {
}
