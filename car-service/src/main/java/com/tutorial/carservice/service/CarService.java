package com.tutorial.carservice.service;

import com.tutorial.carservice.entity.Car;
import com.tutorial.carservice.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<Car> getall(){
        return carRepository.findAll();
    }

    public Car getCarById(Long id){
        return carRepository.findById(id).orElse(null);
    }

    public Car save (Car Car){
        Car useCar =carRepository.save(Car);
        return useCar;
    }

    public List<Car> byUserId(Long userId){
        return carRepository.findByUserId(userId);
    }
}
