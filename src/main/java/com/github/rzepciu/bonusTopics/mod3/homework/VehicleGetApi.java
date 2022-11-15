package com.github.rzepciu.bonusTopics.mod3.homework;

import com.github.rzepciu.bonusTopics.mod3.homework.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(method = RequestMethod.GET ,value = "/vehicles", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class VehicleGetApi {


    VehicleServiceImpl vehicleService;


    @Autowired
    public VehicleGetApi(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping
    public ResponseEntity<List<Vehicle>> getVehicles() {
        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        Resources<Vehicle> vehicleResource = new Resources<>(vehicleList, vehicleService.getLink());
        if (vehicleList != null && !vehicleList.isEmpty()) {
            return new ResponseEntity(vehicleResource, HttpStatus.OK);
        } else if (vehicleList.isEmpty()) {
            return new ResponseEntity(vehicleResource, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(vehicleResource, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable long id) {

        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        Optional<Vehicle> vehicle = vehicleList.stream()
                .filter(vehicles -> vehicles.getVehicleId()==id)
                .findFirst();
        Resource<Vehicle> vehicleResource = new Resource<>(vehicle.get(), vehicleService.getLink());
        if (vehicle.isPresent()) {
            return new ResponseEntity(vehicleResource, HttpStatus.OK);
        } else if (!vehicle.isPresent()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/mark/{mark}")
    public ResponseEntity<Vehicle> getVehicleByMark(@PathVariable String mark) {

        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        List<Vehicle> vehicles = vehicleList.stream()
                .filter(vehicle -> vehicle.getMark().equalsIgnoreCase(mark))
                .collect(Collectors.toList());
        Resources<Vehicle> vehicleResource = new Resources<>(vehicles, vehicleService.getLink());
        if (!vehicles.isEmpty()) {
            return new ResponseEntity(vehicleResource, HttpStatus.OK);
        } else{
            return new ResponseEntity(vehicleResource, HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/model/{model}")
    public ResponseEntity<Vehicle> getVehicleByModel(@PathVariable String model) {
        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        List<Vehicle> vehicles = vehicleList.stream()
                .filter(vehicle -> vehicle.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
        Resources<Vehicle> vehicleResource = new Resources<>(vehicles, vehicleService.getLink());
        if (!vehicles.isEmpty()) {
            return new ResponseEntity(vehicleResource, HttpStatus.OK);
        } else{
            return new ResponseEntity(vehicleResource, HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Vehicle>> getVehicleByColor(@PathVariable String color) {
        List<Vehicle> vehicleList = vehicleService.getAllVehicles();
        List<Vehicle> vehicles = vehicleList.stream()
                .filter(vehicle -> vehicle.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
        Resources<Vehicle> vehicleResource = new Resources<>(vehicles, vehicleService.getLink());
        if (!vehicles.isEmpty()) {
            return new ResponseEntity(vehicleResource, HttpStatus.OK);
        } else{
            return new ResponseEntity(vehicleResource, HttpStatus.NO_CONTENT);
        }

    }
}
