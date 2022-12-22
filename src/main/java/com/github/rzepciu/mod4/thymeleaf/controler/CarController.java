package com.github.rzepciu.mod4.thymeleaf.controler;

import com.github.rzepciu.mod4.thymeleaf.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {
    List<Car> cars;

    public CarController() {
        Car car =  new Car("Bmw", "I8");
        Car car2 =  new Car("Audi", "A4");
        Car car3 =  new Car("Opel", "Vectra");
        Car car4 =  new Car("Opel", "Astra");

        cars = new ArrayList<>();
        cars.add(car);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
    }

    @GetMapping("/car")
    public String getCar(Model model){
//        model.addAttribute("name","andrzej");
//        model.addAttribute("car",car);
        model.addAttribute("cars",cars);
        model.addAttribute("newCar",new Car());

        return "car";
    }

    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car){
        cars.add(car);
        System.out.println(car);
        return "redirect:/car";
    }

}
