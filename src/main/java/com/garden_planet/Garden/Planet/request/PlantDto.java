package com.garden_planet.Garden.Planet.request;

import com.garden_planet.Garden.Planet.model.enums.PlantType;
import com.garden_planet.Garden.Planet.repository.PlantRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class PlantDto {
    private String name;
    private String water;
    private String sunlight;
    private PlantType plantType;
}
