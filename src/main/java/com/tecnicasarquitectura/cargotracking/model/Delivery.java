package com.tecnicasarquitectura.cargotracking.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "delivery")
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="transport_status")
	private Integer transportStatus;
	
	@ManyToOne()
	@JoinColumn(name = "last_know_location", referencedColumnName = "id")
	private Location lastKnowLocation;
	
	@ManyToOne()
	@JoinColumn(name = "current_voyage", referencedColumnName = "id")
	private Voyage currentVoyage;
	
	@ManyToOne()
	@JoinColumn(name = "vehicle_id", referencedColumnName = "id")
	private Vehicle vehicle;
	
	@ManyToOne()
	@JoinColumn(name = "carrier_id", referencedColumnName = "id")
	private Carrier carrier;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="eta")
	private Date eta;
	
	public Delivery() {
	}
	
	public Delivery(Long id) {
		this.id = id;
	}

	public Delivery(Long id, Integer transportStatus, Location lastKnowLocation, Voyage currentVoyage, Vehicle vehicle,
			Carrier carrier, Date eta) {
		this.id = id;
		this.transportStatus = transportStatus;
		this.lastKnowLocation = lastKnowLocation;
		this.currentVoyage = currentVoyage;
		this.vehicle = vehicle;
		this.carrier = carrier;
		this.eta = eta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTransportStatus() {
		return transportStatus;
	}

	public void setTransportStatus(Integer transportStatus) {
		this.transportStatus = transportStatus;
	}

	public Location getLastKnowLocation() {
		return lastKnowLocation;
	}

	public void setLastKnowLocation(Location lastKnowLocation) {
		this.lastKnowLocation = lastKnowLocation;
	}

	public Voyage getCurrentVoyage() {
		return currentVoyage;
	}

	public void setCurrentVoyage(Voyage currentVoyage) {
		this.currentVoyage = currentVoyage;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	
	
}
