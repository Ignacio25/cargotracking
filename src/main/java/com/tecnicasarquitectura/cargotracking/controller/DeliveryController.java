package com.tecnicasarquitectura.cargotracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnicasarquitectura.cargotracking.exception.ResourceNotFoundException;
import com.tecnicasarquitectura.cargotracking.model.Delivery;
import com.tecnicasarquitectura.cargotracking.model.Location;
import com.tecnicasarquitectura.cargotracking.service.DeliveryService;
import com.tecnicasarquitectura.cargotracking.service.LocationService;

@RestController
@RequestMapping("/api")
public class DeliveryController {
	
	@Autowired
	DeliveryService deliveryService;
	
	@Autowired
	LocationService locationService;
	
	@PostMapping("/delivery")
	public Delivery createDelivery(@RequestBody Delivery delivery) {
		return deliveryService.createDelivery(delivery);
	}
	
	@PutMapping("/delivery/{deliveryId}")
	public Delivery updateDelivery(@PathVariable(value = "deliveryId") Long id, @RequestBody Delivery delivery) {
		return deliveryService.updateDelivery(id, delivery);
	}
	
	@PutMapping("/updateCargoLocation/{deliveryId}")
	public ResponseEntity<Delivery> updateCargoLocation(@PathVariable(value = "deliveryId") Long id, @RequestBody Delivery deliveryLoc) {
		
		Location newLocation = locationService.getLocationById(deliveryLoc.getLastKnowLocation().getId())
				.orElseThrow(()-> new ResourceNotFoundException("No se encontro location con id = " + deliveryLoc.getLastKnowLocation().getId()));
		
		Delivery delivery = deliveryService.getDeliveryById(id).map( del -> {
			del.setLastKnowLocation(newLocation);
			return deliveryService.updateDelivery(id, del);
		}).orElseThrow(()-> new ResourceNotFoundException("No se encontro delivery con id = " + id));
		return new ResponseEntity<>(delivery, HttpStatus.OK);
	}
}
