package com.msconcesionario.ms_concesionario.repository;

import com.msconcesionario.ms_concesionario.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehicleRepository extends JpaRepository<Vehicle, String> {

    @Query(value = "SELECT * FROM vehicle WHERE year =:year", nativeQuery = true)
    List<Vehicle> findByYear(int year);

    @Query(value = "SELECT * FROM vehicle WHERE year =?1 AND model =?2", nativeQuery = true)
    List<Vehicle> findByYearAndModel(int year, String model);

    @Query(value = "SELECT * FROM vehicle WHERE model =:model", nativeQuery = true)
    List<Vehicle> findByModel(String model);

    @Query("select v from Vehicle v where v.engine = ?1")
    List<Vehicle> findByEngine(String engine);
}
