package com.tecnicasarquitectura.cargotracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecnicasarquitectura.cargotracking.model.CarrierMovement;

public interface CarrierMovementRepository extends JpaRepository<CarrierMovement, Long> {

}
