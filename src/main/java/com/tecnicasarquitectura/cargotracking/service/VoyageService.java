package com.tecnicasarquitectura.cargotracking.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import com.tecnicasarquitectura.cargotracking.model.Voyage;
import com.tecnicasarquitectura.cargotracking.repository.VoyageRepository;

@Service
public class VoyageService {
	
	@Autowired
	VoyageRepository voyageRepository;
	
	public Voyage createVoyage(Voyage voyage) {
		return voyageRepository.save(voyage);
	}
	
	public List<Voyage> getVoyages() {
		return voyageRepository.findAll();
	}
	
	public void deleteVoyage(Long id) {
		voyageRepository.deleteById(id);
	}
	
	public Optional<Voyage> getVoyageById(Long id) {
		return voyageRepository.findById(id);
	}
}
