package com.example.footballmadrid.Services;

import com.example.footballmadrid.Repositories.PitchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PitchService {
    @Autowired
    private PitchRepository pitchRepository;

}
