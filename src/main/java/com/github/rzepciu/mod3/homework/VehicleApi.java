package com.github.rzepciu.mod3.homework;

import com.github.rzepciu.mod3.homework.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/vehicles", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class VehicleApi {

    @Autowired
    VehicleServiceImpl vehicleService;

    @PostMapping
    public ResponseEntity addVehicle(@Validated @RequestBody Vehicle vehicle) {
        boolean add = vehicleService.getAllVehicles().add(vehicleService.getLinkedVehicle(vehicle));
        if (add) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Vevicle not added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity modVehicle(@Validated @RequestBody Vehicle vehicle, @PathVariable long id) {
        List<Vehicle> allVehicles = vehicleService.getAllVehicles();
        Optional<Vehicle> foundVehicle = allVehicles.stream().filter(v -> v.getVehicleId() == id).findFirst();
        allVehicles.set(allVehicles.indexOf(foundVehicle.get()), vehicleService.getLinkedVehicle(vehicle));
        return new ResponseEntity(HttpStatus.FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVehicle(@Validated @PathVariable long id) {
        List<Vehicle> allVehicles = vehicleService.getAllVehicles();
        Optional<Vehicle> foundVehicle = allVehicles.stream().filter(v -> v.getVehicleId() == id).findFirst();
        allVehicles.remove(allVehicles.indexOf(foundVehicle.get()));
        return new ResponseEntity(HttpStatus.OK);
    }

}
