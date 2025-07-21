package com.garden_planet.Garden.Planet.service;

import com.garden_planet.Garden.Planet.model.PlantModel;
import com.garden_planet.Garden.Planet.model.UserModel;
import com.garden_planet.Garden.Planet.repository.PlantRepository;
import com.garden_planet.Garden.Planet.repository.UserRepository;
import com.garden_planet.Garden.Planet.request.PlantDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlantService {
    private final PlantRepository plantRepository;
    private final UserRepository userRepository;

    public PlantModel save(PlantDto plantDto, Long userId) throws BadRequestException {
        UserModel user = userRepository.findById(userId)
                .orElseThrow(() -> new BadRequestException("User can't be find"));

        PlantModel plant = new PlantModel();
        plant.setName(plantDto.getName());
        plant.setWater(plantDto.getWater());
        plant.setSunlight(plantDto.getSunlight());
        plant.setPlantType(plantDto.getPlantType());

        plant.setUser(user);

        return plantRepository.save(plant);
    }
}
