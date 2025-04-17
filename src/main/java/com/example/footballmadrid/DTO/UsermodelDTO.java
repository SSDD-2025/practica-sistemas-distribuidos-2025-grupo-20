package com.example.footballmadrid.DTO;

import com.example.footballmadrid.models.UserModel;

public class UsermodelDTO {
    String Username;
    Long id;

    public UsermodelDTO(UserModel userModel) {
        this.Username = userModel.getUsername();
        this.id = userModel.getId();
    }


}
