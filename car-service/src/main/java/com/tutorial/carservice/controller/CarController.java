package com.tutorial.carservice.controller;

import com.tutorial.carservice.entity.Car;
import com.tutorial.carservice.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>>getAll(){
        List<Car> Cars =carService.getall();
        //List<Car> cars1 = carService.byUserId(Long.valueOf(1));
        if(Cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(Cars);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable("id") Long id){
        Car Car = carService.getCarById(id);
        if(Car==null){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(Car);
    }

    @PostMapping()
    public ResponseEntity<Car> save(@RequestBody Car Car){

        Car newCar = carService.save(Car);
        return ResponseEntity.ok(newCar);
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") Long userId){
        List<Car> cars = carService.byUserId(userId);
        if(cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

}
