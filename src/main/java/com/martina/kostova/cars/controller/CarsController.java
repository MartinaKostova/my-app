package com.martina.kostova.cars.controller;

import com.martina.kostova.cars.entity.Cars;
import com.martina.kostova.cars.exception.CarsNotFoundException;
import com.martina.kostova.cars.repository.CarsRepository;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("")
public class CarsController {

    private final CarsRepository repository;

    CarsController(CarsRepository repository ) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/cars/all")
    List<Cars> listAllCars() {
        return repository.findAll();
    }

    @GetMapping("/cars")
    List<Cars> getCars(@RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "limit", defaultValue = "30") int limit) {

        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<Cars> cars = repository.findAll(pageableRequest);
        List<Cars> carsEntities = cars.getContent();
        return carsEntities;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/cars")
    Cars createNewCar(@RequestBody Cars newCars) {
        return repository.save(newCars);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/cars/{id}")
    Cars detailsCar(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new CarsNotFoundException(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
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

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
