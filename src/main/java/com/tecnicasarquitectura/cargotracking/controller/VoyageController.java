package com.tecnicasarquitectura.cargotracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnicasarquitectura.cargotracking.model.Voyage;
import com.tecnicasarquitectura.cargotracking.service.VoyageService;

@RestController
@RequestMapping("/api")
public class VoyageController {
	
	@Autowired
	VoyageService voyageService;
	
	@PostMapping("/voyage")
	public ResponseEntity<Voyage> createVoyage(@RequestBody Voyage voyage) {
		Voyage newVoyage =  voyageService.createVoyage(voyage);
		return new ResponseEntity<>(newVoyage, HttpStatus.CREATED);
	}
}
