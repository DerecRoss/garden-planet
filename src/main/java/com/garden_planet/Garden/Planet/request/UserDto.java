package com.garden_planet.Garden.Planet.request;

import com.garden_planet.Garden.Planet.model.PlantModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String phone;
    private String email;
    private String password;
    private List<PlantModel> plants;
}
