package com.martina.kostova.cars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

//@data is Lombok annotation to create all the getter, setter,
// equals, hash and toString methods based on the fields.

//@Entity is a JPA annotation to make this object ready for storage in a JPA-based data store.

@Data
@Entity
@AllArgsConstructor
public class Cars {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Colour colour;

    private Integer speed;

    private String brand;

    private Boolean isAwesome;

    public Cars(Colour colour, Integer speed, String brand, Boolean isAwesome){
        this.colour = colour;
        this.speed = speed;
        this.brand = brand;
        this.isAwesome = isAwesome;
    }

    public Cars() {
    }

}
