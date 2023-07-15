package com.tecnicasarquitectura.cargotracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/voyage")
	public List<Voyage> getVoyages() {
		return voyageService.getVoyages();
	}
	
	@DeleteMapping("/voyage/{voyageId}")
	public void deleteVoyage(@PathVariable(value = "voyageId") Long id) {
		voyageService.deleteVoyage(id);
	}
	
}
