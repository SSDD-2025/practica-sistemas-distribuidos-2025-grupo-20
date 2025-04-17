package com.example.footballmadrid.DTO;

import com.example.footballmadrid.models.PitchModel;

public class pitchmodelDTO {

    String name;
    public pitchmodelDTO(PitchModel pitchModel){
        this.name=pitchModel.getName();
    }

}
