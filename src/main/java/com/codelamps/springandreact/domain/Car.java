package com.codelamps.springandreact.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long carId;
    private String brand;
    private String model;
    private String color;
    private String registerNumber;
    private int years;
    private int price;

    public Car(String brand, String model, String color, String registerNumber, int years, int price, Owner owner){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registerNumber = registerNumber;
        this.years = years;
        this.price = price;
        this.owner = owner;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToMany(mappedBy = "cars")
    private Set<Owner> owners;


}
