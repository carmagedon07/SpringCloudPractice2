package com.tutorial.userservice.service;

import com.tutorial.userservice.entity.User;
import com.tutorial.userservice.model.Bike;
import com.tutorial.userservice.model.Car;
import com.tutorial.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<User> getall(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User save (User user){
        User useNew =userRepository.save(user);
        return useNew;
    }

    public List<com.tutorial.userservice.model.Car> getCars(Long userId){
        List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/byUser/"+userId,List.class);
        return cars;

    }

    public List<Bike> getBike(Long userId){
        List<Bike> bikes = restTemplate.getForObject("http://localhost:8003/bike/byuser/"+userId,List.class);
        return bikes;

    }
}
