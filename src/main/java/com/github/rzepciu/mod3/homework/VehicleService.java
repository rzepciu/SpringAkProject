package com.github.rzepciu.mod3.homework;

import com.github.rzepciu.mod3.homework.model.Vehicle;
import org.springframework.hateoas.Link;

import java.util.List;

public interface VehicleService {

    public List<Vehicle> getAllVehicles();
    public Link getLink();

    Vehicle getLinkedVehicle(Vehicle vehicle);
}
