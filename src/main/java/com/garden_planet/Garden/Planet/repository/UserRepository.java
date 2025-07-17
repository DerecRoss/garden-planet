package com.garden_planet.Garden.Planet.repository;

import com.garden_planet.Garden.Planet.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
