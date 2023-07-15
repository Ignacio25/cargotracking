package com.tecnicasarquitectura.cargotracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecnicasarquitectura.cargotracking.model.Voyage;

public interface VoyageRepository extends JpaRepository<Voyage, Long> {

}
