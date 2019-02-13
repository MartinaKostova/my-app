package com.martina.kostova.cars.repository;

import com.martina.kostova.cars.entity.Cars;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Cars, Long> {


    List<Cars> findAll();
}
