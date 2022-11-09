package com.github.rzepciu.homework;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestApi {

    @GetMapping
    public String getProducts() {
        return "Hello world with GET";
    }
}
