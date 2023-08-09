package com.tecnicasarquitectura.cargotracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnicasarquitectura.cargotracking.model.Vehicle;
import com.tecnicasarquitectura.cargotracking.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	public Vehicle createVehicle(Vehicle v) {
		return vehicleRepository.save(v);
	}
	
	public List<Vehicle> getVehicles() {
		return vehicleRepository.findAll();	
	}
	
	public Optional<Vehicle> getVehicleById(Long id) {
		return vehicleRepository.findById(id);
	}
	
	public void deleteVehicle(Long id) {
		vehicleRepository.deleteById(id);
	}
	
	public Vehicle updateVehicle(Long id, Vehicle v) {

		return vehicleRepository.findById(id)
			      .map( vehicle -> {
			    	  vehicle.setCapacity(v.getCapacity());
			    	  vehicle.setStatus(v.getStatus());
			    	  vehicle.setType(v.getType());
			    	  return vehicleRepository.save(vehicle);
			      })
			      .orElseGet(() -> {
			        return vehicleRepository.save(v);
			      });
	}

}
