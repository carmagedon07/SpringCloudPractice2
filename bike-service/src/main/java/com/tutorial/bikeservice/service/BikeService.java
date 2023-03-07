package com.tutorial.bikeservice.service;


import com.tutorial.bikeservice.entity.Bike;
import com.tutorial.bikeservice.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {
    @Autowired
    BikeRepository bikeRepository;

    public List<Bike> getall(){
        return bikeRepository.findAll();
    }

    public Bike getBikeById(Long id){
        return bikeRepository.findById(id).orElse(null);
    }

    public Bike save (Bike Bike){
        Bike useBike =bikeRepository.save(Bike);
        return useBike;
    }

    public List<Bike> byUserId(Long userId){
        return bikeRepository.findByUserId(userId);
    }
}
