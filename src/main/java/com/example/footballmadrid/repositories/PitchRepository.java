package com.example.footballmadrid.repositories;

import com.example.footballmadrid.models.GameModel;
import com.example.footballmadrid.models.PitchModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PitchRepository extends JpaRepository<PitchModel, Long> {
    public PitchModel getPitchModelById(Long id);
    public Page<PitchModel> findAll(Pageable pageable);

}
