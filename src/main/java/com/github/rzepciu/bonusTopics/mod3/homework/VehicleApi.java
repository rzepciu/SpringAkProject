package com.github.rzepciu.bonusTopics.mod3.homework;

import com.github.rzepciu.bonusTopics.mod3.homework.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/vehicles", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class VehicleApi {

    @Autowired
    VehicleServiceImpl vehicleService;

    @PostMapping
    public ResponseEntity addVehicle(@Validated @RequestBody Vehicle vehicle){
        boolean add  = vehicleService.getAllVehicles().add(vehicleService.getLinkedVehicle(vehicle));
        if (add){
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Vevicle not added",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity modVehicle(@RequestBody Vehicle vehicle, @PathVariable long id){
        List<Vehicle> allVehicles = vehicleService.getAllVehicles();
        List<Vehicle> collect = allVehicles.stream().filter(v -> v.getVehicleId() == id).collect(Collectors.toList());
        allVehicles.set(allVehicles.indexOf(collect),vehicleService.getLinkedVehicle(vehicle));
        return new ResponseEntity(HttpStatus.FOUND);

    }

}
