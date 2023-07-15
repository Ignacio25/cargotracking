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

import com.tecnicasarquitectura.cargotracking.model.Location;
import com.tecnicasarquitectura.cargotracking.service.LocationService;

@RestController
@RequestMapping("/api")
public class LocationController {
	
	@Autowired
	LocationService locService;
	
	@PostMapping("/locations")
	public ResponseEntity<Location> createLocation(@RequestBody Location location) {
		Location newLocation = locService.createLocation(location);
		return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
	}
	
	@GetMapping("/locations")
	public List<Location> getLocations(){
		return locService.getLocations();
	}
	
	@PutMapping("/locations/{locId}")
	public Location updateLocation(@PathVariable(value = "locId") Long id, @RequestBody Location location) {
		return locService.updateLocation(id, location);
	}
	
	@DeleteMapping("/locations/{locId}")
	public void deleteLocation(@PathVariable(value = "locId") Long id) {
		locService.deleteLocation(id);
	}
	
	
}
