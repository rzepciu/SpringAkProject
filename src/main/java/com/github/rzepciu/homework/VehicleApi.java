package com.github.rzepciu.homework;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

//@RestController
//@RequestMapping(value = "/vehicles", produces ={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleApi {

    private List<Vehicle> vehicleList;

    public VehicleApi() {
        this.vehicleList = new ArrayList<>();

        this.vehicleList.add(new Vehicle(1, "Opel", "Astra", "Black"));
        this.vehicleList.add(new Vehicle(2, "Vw", "Pasat", "Silver"));
        this.vehicleList.add(new Vehicle(3, "Porshe", "911", "Red"));
        this.vehicleList.add(new Vehicle(4, "Fiat", "126p", "White"));
        this.vehicleList.add(new Vehicle(5, "Opel", "Vectra", "Red"));
        this.vehicleList.forEach(vehicle -> vehicle.add(linkTo(VehicleApi.class).slash(vehicle.getVehicleId()).withSelfRel()));
    }

    @GetMapping
    public String getProducts() {
        return "Hello world with GET";
    }

//    @GetMapping
//    public ResponseEntity<List<Vehicle>> getVehicles(){
//        Link link = linkTo(VehicleApi.class).withSelfRel();
////        vehicleList.forEach(vehicle -> vehicle.add(linkTo(VehicleApi.class).slash(vehicle.getVehicleId()).withSelfRel()));
//        Resources<Vehicle> vehicleResource = new Resources<>(vehicleList,link);
//        if (vehicleList!=null && !vehicleList.isEmpty()) {
//            return new ResponseEntity(vehicleResource, HttpStatus.OK);
//        } else if (vehicleList.isEmpty()){
//            return new ResponseEntity(vehicleResource, HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity(vehicleResource, HttpStatus.NOT_FOUND);
//        }
//    }
}
