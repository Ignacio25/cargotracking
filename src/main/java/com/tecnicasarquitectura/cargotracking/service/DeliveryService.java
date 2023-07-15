package com.tecnicasarquitectura.cargotracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnicasarquitectura.cargotracking.model.Delivery;
import com.tecnicasarquitectura.cargotracking.repository.DeliveryRepository;

@Service
public class DeliveryService {
	
	@Autowired
	DeliveryRepository deliveryRepository;
	
	public Delivery createDelivery(Delivery delivery) {
		return deliveryRepository.save(delivery);
	}
	
	public List<Delivery> getDeliveries() {
		return deliveryRepository.findAll();
	}
	
	public void deleteDelivery(Long id) {
		deliveryRepository.deleteById(id);
	}
	
	public Optional<Delivery> getDeliveryById(Long id) {
		return deliveryRepository.findById(id);
	}
}
