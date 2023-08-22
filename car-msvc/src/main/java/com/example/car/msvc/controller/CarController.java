package com.example.car.msvc.controller;



import com.example.car.msvc.entity.Car;
import com.example.car.msvc.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Car>>getAll(){
        List<Car>cars = carService.getAllCars();
        if (cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getCarById(@PathVariable("id") Integer id){
        Car carId = carService.getCarById(id);
        if (id == null){
            return ResponseEntity.notFound().build();
        }return ResponseEntity.ok(carId);
    }

    @PostMapping("/crear")
    public ResponseEntity<?>createNewCars(@RequestBody Car car){
        Car car1 = carService.createCar(car);
        if (car == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car1);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Car>>getByUserId(@PathVariable("userId") Integer userId){
        List<Car>cars = carService.byUserId(userId);
        if (cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }


}
