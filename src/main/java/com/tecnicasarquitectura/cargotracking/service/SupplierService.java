package com.tecnicasarquitectura.cargotracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnicasarquitectura.cargotracking.model.Supplier;
import com.tecnicasarquitectura.cargotracking.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	SupplierRepository supplierRepository;
	
	public Supplier createSupplier(Supplier loc) {
		return supplierRepository.save(loc);
	}
	
	public List<Supplier> getSuppliers() {
		return supplierRepository.findAll();	
	}
	
	public Optional<Supplier> getSupplierById(Long id) {
		return supplierRepository.findById(id);
	}
	
	public void deleteSupplier(Long id) {
		supplierRepository.deleteById(id);
	}
	
	public Supplier updateSupplier(Long id, Supplier supplier) {

		return supplierRepository.findById(id)
			      .map( s -> {
			    	  s.setName(supplier.getName());
			    	  s.setType(supplier.getType());
			    	  s.setEmail(supplier.getEmail());
			    	  return supplierRepository.save(s);
			      })
			      .orElseGet(() -> {
			        return supplierRepository.save(supplier);
			      });
	}
}
