package com.codelamps.springandreact.web;

import com.codelamps.springandreact.domain.Car;
import com.codelamps.springandreact.domain.CarRepository;
import com.codelamps.springandreact.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// PENAMBAHAN ANNOTATION @RestController identifies that this class
// will be the controller for the RESTful web service
@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }
}
