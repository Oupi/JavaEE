/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opiframe.java.ReactiveCarShop.service;

import com.opiframe.java.ReactiveCarShop.domain.Car;
import com.opiframe.java.ReactiveCarShop.domain.ICarShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Oula
 */
@Service
public class CarService {

    @Autowired
    ICarShop carRepo;

    boolean isFound;

    public Mono<Car> findById(String id) {
        if (!"".equals(id) && id != null) {
            return carRepo.findById(id);
        }
        return null;
    }

    public Flux<Car> findByType(String type) {
        return carRepo.findByTypeIgnoreCase(type);
    }

    public Flux<Car> getAllCars() {
        return carRepo.findAll();
    }

    public Flux<Car> findByPrice(int greaterThan, int lessThan) {
        return carRepo.findByPrice(greaterThan, lessThan);
    }

    public Flux<Car> findByYear(int year) {
        return carRepo.findByYear(year);
    }

    public boolean addCar(Car car) {
        carRepo.save(car);
        return true;
    }

    public boolean removeCar(String id) {
        carRepo.findById(id).hasElement().subscribe(data -> this.isFound = data);
        if (this.isFound) {
            carRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
