package com.example.footballmadrid.DTO;

import com.example.footballmadrid.models.PitchModel;

public class PitchmodelDTO {

    String name;
    public PitchmodelDTO(PitchModel pitchModel){

        this.name=pitchModel.getName();
    }

}
