package com.msconcesionario.ms_concesionario.service;

import com.msconcesionario.ms_concesionario.dto.VehicleDto;
import com.msconcesionario.ms_concesionario.model.Vehicle;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {

    ResponseEntity<Vehicle> save(VehicleDto dto);
    ResponseEntity<Vehicle> getById(String id);
    ResponseEntity<List<Vehicle>> findByYear(int year);
    ResponseEntity<List<Vehicle>> findByModel(String model);
    ResponseEntity<List<Vehicle>> findByYearAndModel(int year, String model);
    ResponseEntity<List<Vehicle>> findAll();
    ResponseEntity<?> delete(String id);
    ResponseEntity<?> update(String id, VehicleDto dto);
    ResponseEntity<List<Vehicle>> findByEnginee(String motor);

}
