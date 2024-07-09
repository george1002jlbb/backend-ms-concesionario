package com.msconcesionario.ms_concesionario.controller;

import com.msconcesionario.ms_concesionario.dto.VehicleDto;
import com.msconcesionario.ms_concesionario.model.Vehicle;
import com.msconcesionario.ms_concesionario.service.impl.IVehicleImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final IVehicleImpl iservice;

    public VehicleController(IVehicleImpl iservice) {
        this.iservice = iservice;
    }

    @PostMapping
    public ResponseEntity<Vehicle> save(@RequestBody @Valid VehicleDto dto){
        return iservice.save(dto);
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> findAll(){
        return iservice.findAll();
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Vehicle>> findByYear(@PathVariable int year){
        return iservice.findByYear(year);
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<Vehicle>> findByModel(@PathVariable String model){
        return iservice.findByModel(model);
    }

    @GetMapping("/year/{year}/model/{model}")
    public ResponseEntity<List<Vehicle>> findByYearAndModel(@PathVariable int year, @PathVariable String model){
        return iservice.findByYearAndModel(year, model);
    }

    @GetMapping("/engine/{engine}")
    public ResponseEntity<List<Vehicle>> findByEngine(@PathVariable String engine){
        return iservice.findByEnginee(engine);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable String id){
        return iservice.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return iservice.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody VehicleDto dto){
        return iservice.update(id, dto);
    }
}
