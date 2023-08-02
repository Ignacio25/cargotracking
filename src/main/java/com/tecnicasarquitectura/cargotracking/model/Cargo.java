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
@Table(name = "cargo")
public class Cargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tracking_id")
	private Long id;
	
	@ManyToOne()
	@JoinColumn(name = "loc_origin_id", referencedColumnName = "id")
	private Location locOriginId;
	
	@ManyToOne()
	@JoinColumn(name = "loc_dest_id", referencedColumnName = "id")
	private Location locDestId;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="arrival_deadline")
	private Date arrivalDeadline;
	
	@ManyToOne()
	@JoinColumn(name = "delivery_id", referencedColumnName = "id")
	private Delivery deliveryId;
	
	public Cargo(){}
	
	public Cargo(Long id, Location locOriginId, Location locDestId, Date arrivalDeadline, Delivery deliveryId) {
		this.id = id;
		this.locOriginId = locOriginId;
		this.locDestId = locDestId;
		this.arrivalDeadline = arrivalDeadline;
		this.deliveryId = deliveryId;
	}	
	
	public Long getTrackingId() {
		return id;
	}

	public void setTrackingId(Long trackingId) {
		this.id = trackingId;
	}

	public Location getLocOriginId() {
		return locOriginId;
	}

	public void setLocOriginId(Location locOriginId) {
		this.locOriginId = locOriginId;
	}

	public Location getLocDestId() {
		return locDestId;
	}

	public void setLocDestId(Location locDestId) {
		this.locDestId = locDestId;
	}

	public Date getArrivalDeadLine() {
		return arrivalDeadline;
	}

	public void setArrivalDeadLine(Date arrivalDeadline) {
		this.arrivalDeadline = arrivalDeadline;
	}

	public Delivery getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Delivery deliveryId) {
		this.deliveryId = deliveryId;
	}

}
