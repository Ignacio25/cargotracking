package com.tecnicasarquitectura.cargotracking.controller;

import java.util.ArrayList;
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
import com.tecnicasarquitectura.cargotracking.model.CarrierMovement;
import com.tecnicasarquitectura.cargotracking.service.CarrierMovementService;
import com.tecnicasarquitectura.cargotracking.service.VoyageService;

@RestController
@RequestMapping("/api")
public class CarrierMovementController {
	
	@Autowired
	CarrierMovementService carrierMovementService;
	
	@Autowired
	VoyageService voyageService;
	
	@PostMapping("/voyage/{voyageId}/movement")
	public ResponseEntity<CarrierMovement> createCarrierMovement(@PathVariable(value = "voyageId") Long voyageId,@RequestBody CarrierMovement carrierMovement) {
		
		CarrierMovement movement = voyageService.getVoyageById(voyageId).map(voyage -> {
			carrierMovement.setVoyage(voyage);
			return carrierMovementService.createMovement(carrierMovement);
		}).orElseThrow(()-> new ResourceNotFoundException("No se encontro voyage con id = " + voyageId)); 
		return new ResponseEntity<>(movement, HttpStatus.CREATED);
	}
	
	@GetMapping("/carrier_movement")
	public ResponseEntity<List<CarrierMovement>> getCarrierMovements() {
		List<CarrierMovement> movements = new ArrayList<CarrierMovement>();
		movements = carrierMovementService.getCarrierMovements();
		if ( movements.isEmpty() )
			return new ResponseEntity<>(movements, HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(movements, HttpStatus.OK);
	}
	
	@PutMapping("/carrier_movement/{carrierMovementId}")
	public CarrierMovement updateCarrierMovement(@PathVariable(value = "carrierMovementId") Long id, CarrierMovement carrierMovement) {
		return carrierMovementService.updateCarrierMovement(id, carrierMovement);
	}
	
	@DeleteMapping("/carrier_movement/{carrierMovementId}")
	public void deleteCarrierMovement(@PathVariable(value = "carrierMovementId") Long id) {
		carrierMovementService.deleteCarrierMovement(id);
	}

}
