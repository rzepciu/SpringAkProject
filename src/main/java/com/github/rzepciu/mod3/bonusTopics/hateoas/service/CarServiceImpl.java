package com.github.rzepciu.mod3.bonusTopics.hateoas.service;

import com.github.rzepciu.mod3.bonusTopics.hateoas.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> getAllCars() {
        return createListOfCars();
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return createListOfCars()
                .stream()
                .filter(car -> car.getCarId()==id)
                .findFirst();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return createListOfCars()
                .stream()
                .filter(car -> color.equalsIgnoreCase(car.getColor().toString()))
                .collect(Collectors.toList());
    }


    private List<Car> createListOfCars() {
        List<Car> carList = new ArrayList<Car>();

        carList.add(new Car(1l,"Opel","Vectra", "BLACK"));
        carList.add(new Car(2l,"Opel","Astra GTC", "PURPLE"));
        carList.add(new Car(3l,"Volkswagen","Golf 3","GREEN"));
        carList.add(new Car(4l,"BMW","E39", "RED"));
        carList.add(new Car(5l,"Audi","A4", "SILVER"));

        return carList;
    }
}
