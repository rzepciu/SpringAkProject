package com.github.rzepciu.mod4.thymeleaf.controler;

import com.github.rzepciu.mod4.thymeleaf.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    @GetMapping("/car")
    public String getCar(Model model){

        Car car =  new Car("Bmw", "I8");
        model.addAttribute("name","andrzej");
        model.addAttribute("car",car);

        return "car";
    }

}
