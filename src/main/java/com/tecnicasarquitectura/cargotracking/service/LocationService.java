package com.tecnicasarquitectura.cargotracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnicasarquitectura.cargotracking.model.Location;
import com.tecnicasarquitectura.cargotracking.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	LocationRepository locRepository;
	
	public Location createLocation(Location loc) {
		return locRepository.save(loc);
	}
	
	public List<Location> getLocations() {
		return locRepository.findAll();	
	}
	
	public Optional<Location> getLocationById(Long id) {
		return locRepository.findById(id);
	}
	
	public void deleteLocation(Long id) {
		locRepository.deleteById(id);
	}
	
	public Location updateLocation(Long id, Location location) {

		return locRepository.findById(id)
			      .map(loc -> {
			    	  loc.setCode(location.getCode());
			    	  loc.setName(location.getName());
			    	  return locRepository.save(loc);
			      })
			      .orElseGet(() -> {
			        return locRepository.save(location);
			      });
	}

}
