package com.imagestore.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Booking")
public class Booking {
	@Id
	private String id;
	private String psngrName;
	private String departure;
	private String destination;
	private Date travelDate;

	public Booking() {

	}

	public Booking(String id, String psngrName, String departure, String destination) {
		this.id = id;
		this.psngrName = psngrName;
		this.departure = departure;
		this.destination = destination;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPsngrName() {
		return psngrName;
	}

	public void setPsngrName(String psngrName) {
		this.psngrName = psngrName;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

}
