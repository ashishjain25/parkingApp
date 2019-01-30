package com.exercise.parking.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@Table(name="reservation",schema="parking_db_schema")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reservation_id")
	private Integer reservationId;

	//bi-directional one-to-one association to ParkingSpot
	@OneToOne
	@JoinColumn(name="parkingSpotId")
	private ParkingSpot parkingspot;
	
	@Column(name="reservationDate")
	private Date reservationDate;
	
	@Column(name="reservationTime")
	private Date reservationTime;

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public ParkingSpot getParkingspot() {
		return parkingspot;
	}

	public void setParkingspot(ParkingSpot parkingspot) {
		this.parkingspot = parkingspot;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Date reservationTime) {
		this.reservationTime = reservationTime;
	}
	
	
	

	

}