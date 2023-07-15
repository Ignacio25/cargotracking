package com.tecnicasarquitectura.cargotracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnicasarquitectura.cargotracking.model.Cargo;
import com.tecnicasarquitectura.cargotracking.service.CargoService;

@RestController
@RequestMapping("/api")
public class CargoController {														
	
	@Autowired
	CargoService cargoService;
	
	@PostMapping("/cargos")
	public Cargo createCargo(@RequestBody Cargo cargo) {
		return cargoService.createCargo(cargo);
	}
	
	@GetMapping("/cargos")
	public List<Cargo> getCargos(){
		return cargoService.getCargos();
	}
	
	@PutMapping("/cargos/{cargoId}")
	public Cargo updateCargo(@PathVariable(value = "cargoId") Long id, @RequestBody Cargo cargo) {
		return cargoService.updateCargo(id, cargo);
	}
	
	@DeleteMapping("/cargos/{cargoId}")
	public void deleteCargo(@PathVariable(value = "cargoId") Long id) {
		cargoService.deleteCargo(id);
	}
	
	@GetMapping("/cargos/{cargoId}")
	public Cargo getCargoById(@PathVariable(value = "cargoId") Long id){
		return cargoService.getCargoById(id);
	}

}
