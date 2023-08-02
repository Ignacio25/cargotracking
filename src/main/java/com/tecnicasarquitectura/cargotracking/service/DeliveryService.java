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

	public Delivery updateDelivery(Long id, Delivery delivery) {
		return deliveryRepository.findById(id)
				.map( del -> {

					del.setTransportStatus(delivery.getTransportStatus() != null ? delivery.getTransportStatus() : del.getTransportStatus());
					del.setLastKnowLocation(delivery.getLastKnowLocation() != null ? delivery.getLastKnowLocation() : del.getLastKnowLocation());
					del.setCurrentVoyage(delivery.getCurrentVoyage() !=  null ? delivery.getCurrentVoyage() : del.getCurrentVoyage());
					del.setEta(delivery.getEta() != null ? delivery.getEta() : del.getEta());
					return deliveryRepository.save(del);
				})
				.orElseGet(() -> {
					return deliveryRepository.save(delivery);
				});
	}
	
}
