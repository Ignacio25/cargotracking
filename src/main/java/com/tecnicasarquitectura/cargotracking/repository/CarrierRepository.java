package com.tecnicasarquitectura.cargotracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecnicasarquitectura.cargotracking.model.Carrier;

public interface CarrierRepository extends JpaRepository<Carrier, Long>{

}
