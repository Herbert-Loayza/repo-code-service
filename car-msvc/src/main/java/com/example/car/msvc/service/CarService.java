package com.example.car.msvc.service;

import com.example.car.msvc.entity.Car;
import com.example.car.msvc.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public List<Car>getAllCars(){
        return carRepository.findAll();
    }

    public Car getCarById(Integer id){
        return carRepository.findById(id).orElse(null);
    }

    public Car createCar(Car car){
        return carRepository.save(car);
    }

    public List<Car>byUserId(Integer userId){
        return carRepository.findByUserId(userId);
    }
}
