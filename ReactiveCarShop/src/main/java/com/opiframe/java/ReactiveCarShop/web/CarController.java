/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop.web;

import com.opiframe.java.ReactiveCarShop.domain.Car;
import com.opiframe.java.ReactiveCarShop.service.CarService;
import com.opiframe.java.ReactiveCarShop.service.HillBillyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 *
 * @author Oula
 */
@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private HillBillyService hbService;

    @GetMapping(value = "/api/car", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flux<Car>> getCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @PostMapping(value = "/api/car", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postCar(@RequestBody Car car) {
        carService.addCar(car);
        return new ResponseEntity<>("{\"message\": \"Success\"}", HttpStatus.OK);
    }
    
    @GetMapping(value="/api/car/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Car> getCarStream(){
        return carService.streamCars();
    }

}
