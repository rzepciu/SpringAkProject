package com.example.spring_std_project;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductApi {

//    @GetMapping("/products")
//    @GetMapping
//    Użycie dodatkowego value ="/products" dodaje nam kolejnego "/" do drabinki, w tym wypadku adres do metody to http://localhost:8080/products/products
//    @RequestMapping(value ="/products", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public String getProducts(){
        return "Hello world with GET";
    }

//    @PostMapping("/products")
    @PostMapping
    public String addProducts(){
        return "Hello world with POST";
    }

//    @PutMapping("/products")
    @PutMapping
    public String putProducts(){
        return "Hello world with PUT";
    }

//    @DeleteMapping("/products")
    @DeleteMapping
    public String removeProducts(){
        return "Hello world with DELETE";
    }
}
