package com.github.rzepciu.mod3.bonusTopics.hateoas.service;

import com.github.rzepciu.mod3.bonusTopics.hateoas.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getAllCars();

    Optional<Car> getCarById(long id);

    List<Car> getCarsByColor(String color);

}
