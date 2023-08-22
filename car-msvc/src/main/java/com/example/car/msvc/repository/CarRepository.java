package com.example.car.msvc.repository;

import com.example.car.msvc.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car>findByUserId(Integer userId);
}
