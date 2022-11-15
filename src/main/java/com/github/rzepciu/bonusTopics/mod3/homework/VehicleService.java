package com.github.rzepciu.bonusTopics.mod3.homework;

import com.github.rzepciu.bonusTopics.mod3.homework.model.Vehicle;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VehicleService {

    public List<Vehicle> getAllVehicles();
    public Link getLink();

    Vehicle getLinkedVehicle(Vehicle vehicle);
}
