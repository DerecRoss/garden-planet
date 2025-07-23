package com.garden_planet.Garden.Planet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.garden_planet.Garden.Planet.model.enums.PlantType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlantModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String water;

    private String sunlight;

    @Enumerated(EnumType.STRING)
    private PlantType plantType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private UserModel user;
}
