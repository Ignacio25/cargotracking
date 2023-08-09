package com.tecnicasarquitectura.cargotracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecnicasarquitectura.cargotracking.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
