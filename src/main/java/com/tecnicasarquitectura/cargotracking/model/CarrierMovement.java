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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "carrier_movement")
public class CarrierMovement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@OneToOne()
	@JoinColumn(name = "id_arrival_location", referencedColumnName = "id")
	private Location arrivalLocationId;
	
	@OneToOne()
	@JoinColumn(name = "id_departure_location", referencedColumnName = "id")
	private Location departureLocationId;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="departure_time")
	private Date departureTime;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="arrival_time")
	private Date arrivalTime;
	
	@ManyToOne()
	@JoinColumn(name = "id_voyage", referencedColumnName = "id")
	private Voyage voyage;
	
	public CarrierMovement() {
		
	}

	public CarrierMovement(Long id, Location arrivalLocationId, Location departureLocationId, Date departureTime,
			Date arrivalTime, Voyage voyage) {
		this.id = id;
		this.arrivalLocationId = arrivalLocationId;
		this.departureLocationId = departureLocationId;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.voyage = voyage;
	}

	public Location getArrivalLocationId() {
		return arrivalLocationId;
	}

	public void setArrivalLocationId(Location arrivalLocationId) {
		this.arrivalLocationId = arrivalLocationId;
	}

	public Location getDepartureLocationId() {
		return departureLocationId;
	}

	public void setDepartureLocationId(Location departureLocationId) {
		this.departureLocationId = departureLocationId;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}
}
