package com.github.rzepciu.mod3.homework;

import com.github.rzepciu.mod3.homework.model.Vehicle;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Service
public class VehicleServiceImpl implements VehicleService {

    List<Vehicle> vehicleList =  new ArrayList<>();
    private Link link;


    @Override
    public List<Vehicle> getAllVehicles() {
        if (!vehicleList.isEmpty()) {
            return this.vehicleList;
        } else {
            vehicleList = initAllVehiclesList();
            return vehicleList;
        }
    }


    private List<Vehicle> initAllVehiclesList() {

        List<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new Vehicle(1, "Opel", "Astra", "Black"));
        vehicleList.add(new Vehicle(2, "Vw", "Pasat", "Silver"));
        vehicleList.add(new Vehicle(3, "Porshe", "911", "Red"));
        vehicleList.add(new Vehicle(4, "Fiat", "126p", "White"));
        vehicleList.add(new Vehicle(5, "Opel", "Vectra", "Red"));
        vehicleList.forEach(vehicle -> vehicle.add(linkTo(VehicleGetApi.class).slash(vehicle.getVehicleId()).withSelfRel()));
        vehicleList.forEach(vehicle -> vehicle.add(linkTo(VehicleGetApi.class).slash("color").slash(vehicle.getColor()).withSelfRel()));
        vehicleList.forEach(vehicle -> vehicle.add(linkTo(VehicleGetApi.class).slash("mark").slash(vehicle.getMark()).withSelfRel()));
        vehicleList.forEach(vehicle -> vehicle.add(linkTo(VehicleGetApi.class).slash("model").slash(vehicle.getModel()).withSelfRel()));
        return vehicleList;
    }

    @Override
    public Link getLink() {
        if (link==null) {
            return link = linkTo(VehicleGetApi.class).withSelfRel();
        } else {
            return link;
        }
    }

    @Override
    public Vehicle getLinkedVehicle(Vehicle vehicle) {
        vehicle.add(linkTo(VehicleGetApi.class).slash(vehicle.getVehicleId()).withSelfRel());
        vehicle.add(linkTo(VehicleGetApi.class).slash("color").slash(vehicle.getColor()).withSelfRel());
        vehicle.add(linkTo(VehicleGetApi.class).slash("mark").slash(vehicle.getMark()).withSelfRel());
        vehicle.add(linkTo(VehicleGetApi.class).slash("model").slash(vehicle.getModel()).withSelfRel());
        return vehicle;
    }
}
