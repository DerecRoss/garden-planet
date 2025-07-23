package com.garden_planet.Garden.Planet.service;

import com.garden_planet.Garden.Planet.model.UserModel;
import com.garden_planet.Garden.Planet.repository.UserRepository;
import com.garden_planet.Garden.Planet.request.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<UserModel> listNoPageable(){
        return userRepository.findAll();
    }

    public UserModel save(UserDto userDto){
        UserModel user = new UserModel();
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        return userRepository.save(user);
    }
}
