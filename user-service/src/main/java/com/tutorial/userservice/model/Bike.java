package com.tutorial.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
    // @Column(name="NAME")
    private String brand;
    //@Column(name="EMAIL")
    private String models;
}
