package com.tecnicasarquitectura.cargotracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecnicasarquitectura.cargotracking.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
