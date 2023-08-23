package com.example.user.msvc.service;

import com.example.user.msvc.entity.User;
import com.example.user.msvc.models.Bike;
import com.example.user.msvc.models.Car;
import com.example.user.msvc.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    public List<User>getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<Car>getCars(Integer userId){
        List<Car>cars = restTemplate.getForObject("http://car-msvc/cars/byuser/"+userId, List.class);
        return cars;
    }

    public List<Bike>getBikes(Integer userId){
        List<Bike>bikes = restTemplate.getForObject("http://bike-msvc/bikes/byuser/"+userId, List.class);
        return bikes;
    }

}
