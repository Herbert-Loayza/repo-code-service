package com.example.bike.msvc.controller;


import com.example.bike.msvc.entity.Bike;
import com.example.bike.msvc.service.BikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bikes")
public class BikeController {

    private final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Bike>>getAll(){
        List<Bike>bikes = bikeService.getAllBikes();
        if (bikes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getBikeById(@PathVariable("id") Integer id){
        Bike bikeId = bikeService.getBikeById(id);
        if (id == null){
            return ResponseEntity.notFound().build();
        }return ResponseEntity.ok(bikeId);
    }

    @PostMapping("/crear")
    public ResponseEntity<?>createNewBike(@RequestBody Bike bike){
        Bike bike1 = bikeService.createBike(bike);
        if (bike == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bike1);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Bike>>getByUserId(@PathVariable("userId") Integer userId){
        List<Bike>bikes = bikeService.byUserId(userId);
        if (bikes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bikes);
    }

}
