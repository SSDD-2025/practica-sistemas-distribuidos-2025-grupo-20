package com.example.footballmadrid.services;

import com.example.footballmadrid.models.PitchModel;
import com.example.footballmadrid.repositories.PitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PitchService {
    @Autowired
    private PitchRepository pitchRepository;

    public PitchService(){}
    public PitchService(PitchRepository pitchRepository){
        this.pitchRepository = pitchRepository;
    }

    public PitchModel save(PitchModel pitchModel){
        return pitchRepository.save(pitchModel);
    }
}
