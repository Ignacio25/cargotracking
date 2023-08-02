package com.tecnicasarquitectura.cargotracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnicasarquitectura.cargotracking.model.Location;
import com.tecnicasarquitectura.cargotracking.service.LocationService;

@RestController
@RequestMapping("/api")
public class LocationController {
	
	@Autowired
	LocationService locService;
	
	@PostMapping("/createLocation")
	public ResponseEntity<Location> createLocation(@RequestBody Location location) {
		Location newLocation = locService.createLocation(location);
		return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
	}
}
