package com.garden_planet.Garden.Planet.service;

import com.garden_planet.Garden.Planet.model.PlantModel;
import com.garden_planet.Garden.Planet.model.UserModel;
import com.garden_planet.Garden.Planet.repository.PlantRepository;
import com.garden_planet.Garden.Planet.repository.UserRepository;
import com.garden_planet.Garden.Planet.request.PlantDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlantService {
    private final PlantRepository plantRepository;
    private final UserRepository userRepository;

    public PlantModel findByIdOrThrowBadRequestException(Long id) throws BadRequestException {
        return plantRepository.findById(id).orElseThrow(
                () -> new BadRequestException("Plant can't be find"));
    }
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
    public PlantModel update(Long id, PlantDto plantDto) throws BadRequestException {
        PlantModel plant = plantRepository.findById(id).orElseThrow(
                () -> new BadRequestException("plant can't be find"));

        plant.setName(plantDto.getName());
        plant.setWater(plantDto.getWater());
        plant.setSunlight(plantDto.getSunlight());
        plant.setPlantType(plantDto.getPlantType());

        return plantRepository.save(plant);
    }
    public List<PlantModel> findAllPlants(Long id){

        UserModel user = userRepository.findById(id).orElseThrow();
        List<PlantModel> plantsList = user.getPlants()
                .stream()
                .collect(Collectors.toList());

        return plantsList;
    }
    public void delete(Long id) throws BadRequestException {
        plantRepository.delete(findByIdOrThrowBadRequestException(id));
    }
}
