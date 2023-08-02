package com.tecnicasarquitectura.cargotracking.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.tecnicasarquitectura.cargotracking.model.Cargo;
import com.tecnicasarquitectura.cargotracking.repository.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	CargoRepository cargoRepository;
	
	public Cargo createCargo(Cargo cargo) {
		return cargoRepository.save(cargo);
	}
	
	public List<Cargo> getCargos() {
		return cargoRepository.findAll();
	}
	
	public Cargo updateCargo(Long id, Cargo cargo) {

		return cargoRepository.findById(id)
			      .map(carg -> {
			    	  carg.setLocOriginId(cargo.getLocOriginId());
			    	  carg.setLocDestId(cargo.getLocDestId());
			    	  carg.setArrivalDeadLine(cargo.getArrivalDeadLine());
			    	  carg.setDeliveryId(cargo.getDeliveryId());
			    	  return cargoRepository.save(carg);
			      })
			      .orElseGet(() -> {
			        return cargoRepository.save(cargo);
			      });
	}
	
	public Cargo getCargoById(Long trackingId) {
		return cargoRepository.findById(trackingId)
					.orElseThrow(() -> null);
	}

}
