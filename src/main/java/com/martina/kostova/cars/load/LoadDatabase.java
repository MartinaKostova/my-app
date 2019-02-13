package com.martina.kostova.cars.load;

import com.martina.kostova.cars.entity.Cars;
import com.martina.kostova.cars.entity.Colour;
import com.martina.kostova.cars.repository.CarsRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Slf4j is a Lombok annotation to autocreate an Slf4j-based LoggerFactory as log,
// allowing us to log these newly created "cars".

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(CarsRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Cars(Colour.BLACK,20, "BMW", true)));
            log.info("Preloading " + repository.save(new Cars(Colour.PINK,320, "AUDI", true)));
            log.info("Preloading " + repository.save(new Cars(Colour.BLACK,27, "BMW", true)));
            log.info("Preloading " + repository.save(new Cars(Colour.RED,50, "OPEL", true)));
            log.info("Preloading " + repository.save(new Cars(Colour.RED,28, "VOLVO", true)));
        };
    }
}