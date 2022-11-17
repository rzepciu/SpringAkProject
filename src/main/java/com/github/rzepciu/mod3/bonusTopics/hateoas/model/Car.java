package com.github.rzepciu.mod3.bonusTopics.hateoas.model;

import org.springframework.hateoas.ResourceSupport;

public class Car extends ResourceSupport {

    private long carId;
    private String brand;
    private String model;
    private String color;

    public Car() {
    }

    public Car(long carId, String brand, String model, String color) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
