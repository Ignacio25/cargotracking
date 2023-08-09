package com.tecnicasarquitectura.cargotracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecnicasarquitectura.cargotracking.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
