package com.garden_planet.Garden.Planet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_tb")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phone;

    private String email;

}
