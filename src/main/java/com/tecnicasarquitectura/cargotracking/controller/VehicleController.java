package com.tecnicasarquitectura.cargotracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnicasarquitectura.cargotracking.exception.ResourceNotFoundException;
import com.tecnicasarquitectura.cargotracking.model.Vehicle;
import com.tecnicasarquitectura.cargotracking.service.VehicleService;

@RestController
@RequestMapping("/api")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@PostMapping("/createVehicle")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
		Vehicle newVehicle = vehicleService.createVehicle(vehicle);
		return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
	}
	
	@GetMapping("/listAllVehicles")
	public List<Vehicle> getVehicles(){
		return vehicleService.getVehicles();
	}
	
	@GetMapping("/viewVehicle/{vehicleId}")
	public Vehicle getVehicleById(@PathVariable(value = "vehicleId") Long id) {
		
		return vehicleService.getVehicleById(id).
				orElseThrow(()-> new ResourceNotFoundException("No se encontro vehiculo con id = " + id)); 
	}
	
	@PutMapping("/updateVehicle/{vehicleId}")
	public Vehicle updateVehicle(@PathVariable(value = "vehicleId") Long id, @RequestBody Vehicle vehicle) {
		return vehicleService.updateVehicle(id, vehicle);
	}
	
	@DeleteMapping("/deleteVehicle/{vehicleId}")
	public void deleteVehicle(@PathVariable(value = "vehicleId") Long id) {
		vehicleService.deleteVehicle(id);
	}

}
