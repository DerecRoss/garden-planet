package com.garden_planet.Garden.Planet.controller;

import com.garden_planet.Garden.Planet.model.UserModel;
import com.garden_planet.Garden.Planet.request.UserDto;
import com.garden_planet.Garden.Planet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> save(@RequestBody UserDto userDto){
        UserModel user = userService.save(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
