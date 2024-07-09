package com.msconcesionario.ms_concesionario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    private String id;
    private String brand;
    private String model;
    private String engine;
    private int year;
    private int stock;
    private boolean status;
}
