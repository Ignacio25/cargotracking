package com.tecnicasarquitectura.cargotracking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "voyage")
public class Voyage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="voyage_number")
	private Long voyageNumber;
	
	public Voyage() {
		
	}

	public Voyage(Long id, Long voyageNumber) {
		this.id = id;
		this.voyageNumber = voyageNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVoyageNumber() {
		return voyageNumber;
	}

	public void setVoyageNumber(Long voyageNumber) {
		this.voyageNumber = voyageNumber;
	}
	
}
