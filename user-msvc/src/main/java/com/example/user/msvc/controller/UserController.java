package com.example.user.msvc.controller;


import com.example.user.msvc.entity.User;
import com.example.user.msvc.models.Bike;
import com.example.user.msvc.models.Car;
import com.example.user.msvc.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/listar")
    public ResponseEntity<List<User>>getAll(){
        List<User>users = userService.getAllUsers();
        if (users.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?>getUserById(@PathVariable("id") Integer id){
        User userId = userService.getUserById(id);
        if (id == null){
            return ResponseEntity.notFound().build();
        }return ResponseEntity.ok(userId);
    }

    @PostMapping("/crear")
    public ResponseEntity<?>createNewUsers(@RequestBody User user){
        User user1 = userService.createUser(user);
        if (user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user1);
    }


//    @CircuitBreaker(name = "car-msvcCB", fallbackMethod = "fallbackGetCars")
    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>>getCars(@PathVariable("userId")Integer userId){
        User user= userService.getUserById(userId);
        if (user==null){
            return ResponseEntity.notFound().build();
        }
        List<Car> cars = userService.getCars(userId);
        return ResponseEntity.ok(cars);
    }

//    @CircuitBreaker(name = "bike-msvcCB", fallbackMethod = "fallbackGetBikes")
    @GetMapping("/bikes/{userId}")
    public ResponseEntity<List<Bike>>getBikes(@PathVariable("userId")Integer userId){
        User user= userService.getUserById(userId);
        if (user==null){
            return ResponseEntity.notFound().build();
        }
        List<Bike> bikes = userService.getBikes(userId);
        return ResponseEntity.ok(bikes);
    }

}
