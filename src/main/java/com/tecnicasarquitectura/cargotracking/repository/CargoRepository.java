package com.tecnicasarquitectura.cargotracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecnicasarquitectura.cargotracking.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

}