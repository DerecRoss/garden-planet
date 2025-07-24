package com.garden_planet.Garden.Planet.controller;

import com.garden_planet.Garden.Planet.model.PlantModel;
import com.garden_planet.Garden.Planet.request.PlantDto;
import com.garden_planet.Garden.Planet.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plants")
@RequiredArgsConstructor
public class PlantController {
    private final PlantService plantService;

    @PostMapping("/user/{id}")
    public ResponseEntity<PlantModel> save(@PathVariable Long id,@RequestBody PlantDto plantDto) throws BadRequestException {
        PlantModel plant = plantService.save(plantDto, id);
        return new ResponseEntity<>(plant, HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws BadRequestException {
        plantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<PlantModel> update(@PathVariable Long id, @RequestBody PlantDto plantDto) throws BadRequestException {
        PlantModel plant = plantService.update(id, plantDto);
        return new ResponseEntity<>(plant, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{id}/living-being")
    public ResponseEntity<List<PlantModel>> findAllPlants(@PathVariable Long id){
        List<PlantModel> plants = plantService.findAllPlants(id);
        return new ResponseEntity<>(plants, HttpStatus.OK);
    }
}
