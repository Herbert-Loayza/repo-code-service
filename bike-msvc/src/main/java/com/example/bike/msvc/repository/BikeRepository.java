package com.example.bike.msvc.repository;

import com.example.bike.msvc.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer> {

     List<Bike>findByUserId(Integer userId);
}
