package com.example.spring_std_project;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestApi {

//    moduł 3 lekcja 7

    @GetMapping
    public ResponseEntity<String> get (){
        return new ResponseEntity<String>("Spanish_Inquisition", HttpStatus.OK);
    }
}
