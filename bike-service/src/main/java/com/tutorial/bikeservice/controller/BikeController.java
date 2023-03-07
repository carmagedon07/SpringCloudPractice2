package com.tutorial.bikeservice.controller;



import com.tutorial.bikeservice.entity.Bike;
import com.tutorial.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {
    @Autowired
    BikeService BikebikeService;

    @GetMapping
    public ResponseEntity<List<Bike>>getAll(){
        List<Bike> Bikes =BikebikeService.getall();
        if(Bikes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(Bikes);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(@PathVariable("id") Long id){
        Bike Bike = BikebikeService.getBikeById(id);
        if(Bike==null){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(Bike);
    }

    @PostMapping()
    public ResponseEntity<Bike> save(@RequestBody Bike Bike){

        Bike newBike = BikebikeService.save(Bike);
        return ResponseEntity.ok(newBike);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Bike>> getByUserId(@PathVariable("userId") Long userId){
        List<Bike> Bikes = BikebikeService.byUserId(userId);
        if(Bikes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(Bikes);
    }

}
