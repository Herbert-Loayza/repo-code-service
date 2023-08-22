package com.example.bike.msvc.service;


import com.example.bike.msvc.entity.Bike;
import com.example.bike.msvc.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }


    public List<Bike>getAllBikes(){
        return bikeRepository.findAll();
    }

    public Bike getBikeById(Integer id){
        return bikeRepository.findById(id).orElse(null);
    }

    public Bike createBike(Bike bike){
        return bikeRepository.save(bike);
    }

    public List<Bike>byUserId(Integer userId){
        return bikeRepository.findByUserId(userId);
    }
}
