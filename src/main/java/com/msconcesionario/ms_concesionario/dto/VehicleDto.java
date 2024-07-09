package com.msconcesionario.ms_concesionario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

    @NotBlank(message = "the field brand is mandatory")
    @NotEmpty
    private String brand;

    @NotBlank(message = "the field model is mandatory")
    @NotEmpty
    private String model;

    @NotBlank(message = "the field engine is mandatory")
    @NotEmpty
    private String engine;

    @PositiveOrZero(message = "the field year can't be negative")
    private int year;

    @PositiveOrZero(message = "the field stock can't be negative")
    private int stock;

    private boolean status;
}
