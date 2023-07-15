package com.tecnicasarquitectura.cargotracking.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.tecnicasarquitectura.cargotracking.model.CarrierMovement;
import com.tecnicasarquitectura.cargotracking.repository.CarrierMovementRepository;

@Service
public class CarrierMovementService {
	
	@Autowired
	CarrierMovementRepository carrierMovementRepository;
	
	public CarrierMovement createMovement(CarrierMovement carrierMovement) {
		return carrierMovementRepository.save(carrierMovement);
	}
	
	public List<CarrierMovement> getCarrierMovements() {
		return carrierMovementRepository.findAll();
	}
	
	public void deleteCarrierMovement(Long id) {
		carrierMovementRepository.deleteById(id);
	}
	
	public CarrierMovement updateCarrierMovement(Long id, CarrierMovement carrierMovement) {

		return carrierMovementRepository.findById(id)
			      .map( cm -> {
			    	  cm.setDepartureLocationId(carrierMovement.getDepartureLocationId());
			    	  cm.setArrivalLocationId(carrierMovement.getArrivalLocationId());
			    	  cm.setDepartureTime(carrierMovement.getDepartureTime());
			    	  cm.setArrivalTime(carrierMovement.getArrivalTime());
			    	  return carrierMovementRepository.save(cm);
			      })
			      .orElseGet(() -> {
			        return carrierMovementRepository.save(carrierMovement);
			      });
	}

}
