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
import com.tecnicasarquitectura.cargotracking.model.Carrier;
import com.tecnicasarquitectura.cargotracking.service.CarrierService;

@RestController
@RequestMapping("/api")
public class CarrierController {
	
	@Autowired
	CarrierService carrierService;
	
	@PostMapping("/createCarrier")
	public ResponseEntity<Carrier> createCarrier(@RequestBody Carrier carrier) {
		Carrier newCarrier = carrierService.createCarrier(carrier);
		return new ResponseEntity<>(newCarrier, HttpStatus.CREATED);
	}
	
	@GetMapping("/listAllCarriers")
	public List<Carrier> getCarriers(){
		return carrierService.getCarriers();
	}
	
	@GetMapping("/viewCarrier/{carrierId}")
	public Carrier getCarrierById(@PathVariable(value = "carrierId") Long id) {
		
		return carrierService.getCarrierById(id).
				orElseThrow(()-> new ResourceNotFoundException("No se encontro carrier con id = " + id)); 
	}
	
	@PutMapping("/updateCarrier/{carrierId}")
	public Carrier updateCarrier(@PathVariable(value = "carrierId") Long id, @RequestBody Carrier carrier) {
		return carrierService.updateCarrier(id, carrier);
	}
	
	@DeleteMapping("/deleteCarrier/{carrierId}")
	public void deleteCarrier(@PathVariable(value = "carrierId") Long id) {
		carrierService.deleteCarrier(id);
	}

}
