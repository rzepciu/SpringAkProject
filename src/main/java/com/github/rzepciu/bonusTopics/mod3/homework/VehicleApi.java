package com.github.rzepciu.bonusTopics.mod3.homework;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/vehicles", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class VehicleApi {

    private List<Vehicle> vehicleList;

    private Link link;

    public VehicleApi() {
        link = linkTo(VehicleApi.class).withSelfRel();

        this.vehicleList = null;
        this.vehicleList = new ArrayList<>();

        this.vehicleList.add(new Vehicle(1, "Opel", "Astra", "Black"));
        this.vehicleList.add(new Vehicle(2, "Vw", "Pasat", "Silver"));
        this.vehicleList.add(new Vehicle(3, "Porshe", "911", "Red"));
        this.vehicleList.add(new Vehicle(4, "Fiat", "126p", "White"));
        this.vehicleList.add(new Vehicle(5, "Opel", "Vectra", "Red"));
        this.vehicleList.forEach(vehicle -> vehicle.add(linkTo(VehicleApi.class).slash(vehicle.getVehicleId()).withSelfRel()));
        this.vehicleList.forEach(vehicle -> vehicle.add(linkTo(VehicleApi.class).slash(vehicle.getColor()).withSelfRel()));
        this.vehicleList.forEach(vehicle -> vehicle.add(linkTo(VehicleApi.class).slash(vehicle.getMark()).withSelfRel()));
        this.vehicleList.forEach(vehicle -> vehicle.add(linkTo(VehicleApi.class).slash(vehicle.getModel()).withSelfRel()));
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getVehicles() {
        Resources<Vehicle> vehicleResource = new Resources<>(vehicleList, link);
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

        Optional<Vehicle> vehicle = vehicleList.stream()
                .filter(vehicles -> vehicles.getVehicleId()==id)
                .findFirst();
        if (vehicle.isPresent()) {
            return new ResponseEntity(vehicle.get(), HttpStatus.OK);
        } else if (!vehicle.isPresent()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/{mark}")
    public ResponseEntity<Vehicle> getVehicleByMark(@PathVariable String mark) {

        Optional<Vehicle> vehicle = vehicleList.stream()
                .filter(vehicles -> vehicles.getMark()==mark)
                .findFirst();
        if (vehicle.isPresent()) {
            return new ResponseEntity(vehicle.get(), HttpStatus.OK);
        } else if (!vehicle.isPresent()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/{model}")
    public ResponseEntity<Vehicle> getVehicleByModel(@PathVariable String model) {

        Optional<Vehicle> vehicle = vehicleList.stream()
                .filter(vehicles -> vehicles.getModel()==model)
                .findFirst();
        if (vehicle.isPresent()) {
            return new ResponseEntity(vehicle.get(), HttpStatus.OK);
        } else if (!vehicle.isPresent()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/{color}")
    public ResponseEntity<Vehicle> getVehicleByColor(@PathVariable String color) {

        Optional<Vehicle> vehicle = vehicleList.stream()
                .filter(vehicles -> vehicles.getColor()==color)
                .findFirst();
        if (vehicle.isPresent()) {
            return new ResponseEntity(vehicle.get(), HttpStatus.OK);
        } else if (!vehicle.isPresent()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
