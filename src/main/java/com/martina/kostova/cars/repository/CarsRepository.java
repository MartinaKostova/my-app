package com.martina.kostova.cars.repository;

import com.martina.kostova.cars.entity.Cars;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarsRepository extends JpaRepository<Cars, Long> {

    List<Cars> findByBrand(String brand);
//    List<Cars> findAll();
//    List<Cars> findById(Long id);
}
