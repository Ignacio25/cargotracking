package com.tecnicasarquitectura.cargotracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnicasarquitectura.cargotracking.model.Carrier;
import com.tecnicasarquitectura.cargotracking.repository.CarrierRepository;

@Service
public class CarrierService {
	
	@Autowired
	CarrierRepository carrierRepository;
	
	public Carrier createCarrier(Carrier c) {
		return carrierRepository.save(c);
	}
	
	public List<Carrier> getCarriers() {
		return carrierRepository.findAll();	
	}
	
	public Optional<Carrier> getCarrierById(Long id) {
		return carrierRepository.findById(id);
	}
	
	public void deleteCarrier(Long id) {
		carrierRepository.deleteById(id);
	}
	
	public Carrier updateCarrier(Long id, Carrier carrier) {

		return carrierRepository.findById(id)
			      .map(c -> {
			    	  c.setName(carrier.getName());
			    	  c.setPhone(carrier.getPhone());
			    	  return carrierRepository.save(c);
			      })
			      .orElseGet(() -> {
			        return carrierRepository.save(carrier);
			      });
	}

}
