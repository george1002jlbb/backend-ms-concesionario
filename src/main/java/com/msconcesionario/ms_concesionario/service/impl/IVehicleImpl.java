package com.msconcesionario.ms_concesionario.service.impl;

import com.msconcesionario.ms_concesionario.dto.VehicleDto;
import com.msconcesionario.ms_concesionario.model.Vehicle;
import com.msconcesionario.ms_concesionario.repository.IVehicleRepository;
import com.msconcesionario.ms_concesionario.service.IVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class IVehicleImpl implements IVehicleService {

    private final IVehicleRepository iVehicleRepository;

    @Override
    public ResponseEntity<Vehicle> save(VehicleDto dto) {
        Vehicle vehicle = Vehicle.builder()
                .id(UUID.randomUUID().toString())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .engine(dto.getEngine())
                .year(dto.getYear())
                .stock(dto.getStock())
                .status(dto.isStatus())
                .build();
        var user = iVehicleRepository.save(vehicle);
        return ResponseEntity.ok().body(user);
    }

    @Override
    public ResponseEntity<Vehicle> getById(String id) {
        Optional<Vehicle> optional = iVehicleRepository.findById(id);
        return optional.map(vehicle -> ResponseEntity.ok().body(vehicle)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @Override
    public ResponseEntity<List<Vehicle>> findByYear(int year) {
        if(year > 0){
            List<Vehicle> vehicles = iVehicleRepository.findByYear(year);
            return ResponseEntity.ok().body(vehicles);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public ResponseEntity<List<Vehicle>> findByModel(String model) {
        if(!model.isBlank()){
            List<Vehicle> vehicles = iVehicleRepository.findByModel(model);
            return ResponseEntity.ok().body(vehicles);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public ResponseEntity<List<Vehicle>> findByYearAndModel(int year, String model) {
        if(year > 0){
            List<Vehicle> vehicles = iVehicleRepository.findByYearAndModel(year, model);
            return ResponseEntity.ok().body(vehicles);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public ResponseEntity<List<Vehicle>> findAll() {
        return ResponseEntity.ok().body(iVehicleRepository.findAll());
    }

    @Override
    public ResponseEntity<?> delete(String id) {
        Optional<Vehicle> optional = iVehicleRepository.findById(id);
        if(optional.isPresent()){
            iVehicleRepository.delete(optional.get());
            return ResponseEntity.ok().body("vehicle deleted");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vehicle no exists");

    }

    @Override
    public ResponseEntity<?> update(String id, VehicleDto dto) {
        Optional<Vehicle> optional = iVehicleRepository.findById(id);
        if(optional.isPresent()){
            Vehicle currentVechicle = optional.get();
            currentVechicle.setBrand(dto.getBrand());
            currentVechicle.setModel(dto.getModel());
            currentVechicle.setEngine(dto.getEngine());
            currentVechicle.setYear(dto.getYear());
            currentVechicle.setStock(dto.getStock());
            currentVechicle.setStatus(dto.isStatus());

            iVehicleRepository.save(currentVechicle);

            return ResponseEntity.ok().body(currentVechicle);
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("vehicle no exists");
    }

    @Override
    public ResponseEntity<List<Vehicle>> findByEnginee(String motor) {
        return ResponseEntity.ok().body(iVehicleRepository.findByEngine(motor));
    }
}
