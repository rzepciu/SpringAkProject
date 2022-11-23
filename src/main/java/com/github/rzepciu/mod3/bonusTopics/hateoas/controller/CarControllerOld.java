package com.github.rzepciu.mod3.bonusTopics.hateoas.controller;

import com.github.rzepciu.mod3.bonusTopics.hateoas.model.Car;
import com.github.rzepciu.mod3.bonusTopics.hateoas.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping (value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarControllerOld {

    private CarService carService;

    @Autowired
    public CarControllerOld(CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public ResponseEntity<Resources<Car>> getCars(){
        Link link = linkTo(CarControllerOld.class).withSelfRel();
        List<Car> allCars = carService.getAllCars();
        allCars.forEach(car -> car.add(linkTo(CarControllerOld.class).slash(car.getCarId()).withSelfRel()));
        Resources<Car> carResource = new Resources<>(allCars,link);
        return new ResponseEntity(carResource, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource<Car>> getCarById(@PathVariable long id){
        Link link = linkTo(CarControllerOld.class).slash(id).withSelfRel().withSelfRel();

        Optional<Car> carById = carService.getCarById(id);

        Resource<Car> carResource = new Resource(carById.get(),link);

        return new ResponseEntity<>(carResource,HttpStatus.OK);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<Resources<Car>> getCarByColor(@PathVariable String color){
        List<Car> carsByColor = carService.getCarsByColor(color);
        carsByColor.forEach(car -> car.add(linkTo(CarControllerOld.class).slash(car.getColor()).withSelfRel()));
//        carsByColor.forEach(car -> car.add(linkTo(CarController.class).withRel("allColors")));
        Link link = linkTo(CarControllerOld.class).withSelfRel();
        Resources<Car> carResource = new Resources<>(carsByColor,link);
        return new ResponseEntity(carResource,HttpStatus.OK);
    }




}
