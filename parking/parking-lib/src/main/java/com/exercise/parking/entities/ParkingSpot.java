package com.exercise.parking.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the parkingspot database table.
 * 
 */
@Entity
@Table(name="parkingspot",schema="parking_db_schema")
public class ParkingSpot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="parkingspot_id")
	private Integer parkingSpotId;

	@Column(name="latitude")
	private BigDecimal latitude;

	@Column(name="longitude")
	private BigDecimal longitude;

	//bi-directional one-to-one association to Reservation
	@OneToOne(mappedBy="parkingspot")
	private Reservation reservation;

	
	public Integer getParkingSpotId() {
		return parkingSpotId;
	}


	public void setParkingSpotId(Integer parkingSpotId) {
		this.parkingSpotId = parkingSpotId;
	}


	public BigDecimal getLatitude() {
		return latitude;
	}


	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}


	public BigDecimal getLongitude() {
		return longitude;
	}


	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	

}