package com.tutorial.bikeservice.repository;


import com.tutorial.bikeservice.entity.Bike;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike,Long> {

    List<Bike> findByUserId(Long userId);
}
