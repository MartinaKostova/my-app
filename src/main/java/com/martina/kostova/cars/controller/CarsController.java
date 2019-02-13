package com.martina.kostova.cars.controller;

import com.martina.kostova.cars.entity.Cars;
import com.martina.kostova.cars.entity.Colour;
import com.martina.kostova.cars.exception.CarsNotFoundException;
import com.martina.kostova.cars.repository.CarsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class CarsController {

    private final CarsRepository repository;


    CarsController(CarsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cars")
    List<Cars> listAllCars() {
        return repository.findAll();
    }

    @PostMapping("/cars")
    Cars createNewCar(@RequestBody Cars newCars) {
        return repository.save(newCars);
    }

    @GetMapping("/cars/{id}")
    Cars detailsCar(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CarsNotFoundException(id));
    }

    @PutMapping("/cars/{id}")
    Cars updateCar(@RequestBody Cars newCars, @PathVariable Long id) {

        return repository.findById(id)
                .map(cars -> {
                    cars.setColour(newCars.getColour());
                    cars.setSpeed(newCars.getSpeed());
                    cars.setBrand(newCars.getBrand());
                    cars.setIsAwesome(newCars.getIsAwesome());
                    return repository.save(cars);
                })
                .orElseGet(() -> {
                    newCars.setId(id);
                    return repository.save(newCars);
                });
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
