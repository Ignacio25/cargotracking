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

import com.tecnicasarquitectura.cargotracking.exception.ResourceNotFoundException;
import com.tecnicasarquitectura.cargotracking.model.Supplier;
import com.tecnicasarquitectura.cargotracking.service.SupplierService;

@RestController
@RequestMapping("/api")
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	@PostMapping("/createSupplier")
	public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
		Supplier newSupplier = supplierService.createSupplier(supplier);
		return new ResponseEntity<>(newSupplier, HttpStatus.CREATED);
	}
	
	@GetMapping("/listAllSuppliers")
	public List<Supplier> getSuppliers(){
		return supplierService.getSuppliers();
	}
	
	@GetMapping("/viewSupplier/{supplierId}")
	public Supplier getSupplierById(@PathVariable(value = "supplierId") Long id) {
		
		return supplierService.getSupplierById(id).
				orElseThrow(()-> new ResourceNotFoundException("No se encontro supplier con id = " + id)); 
	}
	
	@PutMapping("/updateSupplier/{supplierId}")
	public Supplier updateSupplierId(@PathVariable(value = "supplierId") Long id, @RequestBody Supplier supplier) {
		return supplierService.updateSupplier(id, supplier);
	}
	
	@DeleteMapping("/deleteSupplier/{supplierId}")
	public void deleteSupplier(@PathVariable(value = "supplierId") Long id) {
		supplierService.deleteSupplier(id);
	}

}
