package com.example.footballmadrid.services;

import com.example.footballmadrid.models.PitchModel;
import com.example.footballmadrid.repositories.PitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PitchService {
    @Autowired
    private PitchRepository pitchRepository;

    public PitchService(){}
    public PitchService(PitchRepository pitchRepository){
        this.pitchRepository = pitchRepository;
    }
    public Page<PitchModel> getPitches(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return pitchRepository.findAll(pageable);
    }

    public PitchModel getPitchModelById(Long id){
        return pitchRepository.findById(id).get();
    }


    public PitchModel save(PitchModel pitchModel){
        return pitchRepository.save(pitchModel);
    }



}
