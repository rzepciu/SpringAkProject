package com.github.rzepciu.mod4.thymeleaf.controler;

import com.github.rzepciu.mod4.thymeleaf.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/car")
    public String getCar(Model model){

        Car car =  new Car("Bmw", "I8");
        Car car2 =  new Car("Audi", "A4");
        Car car3 =  new Car("Opel", "Vectra");
        Car car4 =  new Car("Opel", "Astra");
        List<Car> cars = Arrays.asList(car,car2,car3,car4);
        model.addAttribute("name","andrzej");
        model.addAttribute("car",car);
        model.addAttribute("cars",cars);

        return "car";
    }

}
