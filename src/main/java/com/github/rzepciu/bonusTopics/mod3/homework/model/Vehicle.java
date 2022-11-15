package com.github.rzepciu.bonusTopics.mod3.homework.model;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Vehicle extends ResourceSupport {

    @NotNull
    @Min(1)
    private long vehicleId;
    @NotNull
    private String mark;
    @NotNull
    private String model;
    @NotNull
    private String color;

    public Vehicle(long vehilceId, String mark, String model, String color) {
        this.vehicleId = vehilceId;
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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
