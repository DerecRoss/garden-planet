package com.garden_planet.Garden.Planet.controller;

import com.garden_planet.Garden.Planet.model.PlantModel;
import com.garden_planet.Garden.Planet.repository.PlantRepository;
import com.garden_planet.Garden.Planet.request.PlantDto;
import com.garden_planet.Garden.Planet.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plants")
@RequiredArgsConstructor
public class PlantController {
    private final PlantService plantService;

    @PostMapping("/user/{Userid}")
    public ResponseEntity<PlantModel> save(@PathVariable Long Userid, PlantDto plantDto) throws BadRequestException {
        PlantModel plant = plantService.save(plantDto, Userid);
        return new ResponseEntity<>(plant, HttpStatus.CREATED);
    }
}
