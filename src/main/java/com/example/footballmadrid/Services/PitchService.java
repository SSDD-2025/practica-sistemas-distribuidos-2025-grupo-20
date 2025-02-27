package com.example.footballmadrid.Services;

import com.example.footballmadrid.Models.PitchModel;
import com.example.footballmadrid.Repositories.PitchRepository;
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
