package model;

import java.util.Random;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 *
 * Property class
 */

public abstract class Property implements IProperty {

	protected int propertyID;
	
	protected int numberOfBedRoom;
	
	protected int numberOfBathRoom;
	
	protected float squareFootage;
	
	protected String streetName;
	
	protected String city;
	
	protected String postalCode;
	
	protected Boolean status;
	
	protected Property() {
		
	}

	public int getID() {
		return propertyID;
	}

	public void setStatus(Boolean stat) {
		this.status = stat;
	}

		
	protected Property(int numberOfBedRoom, int numberOfBathRoom,
			float squareFootage, String streetName, String city, String postalCode) {
		this.propertyID = new Random().nextInt(90000) + 10000;
		this.numberOfBedRoom = numberOfBedRoom;
		this.numberOfBathRoom = numberOfBathRoom;
		this.squareFootage = squareFootage;
		this.streetName = streetName;
		this.city = city;
		this.postalCode = postalCode;
		this.status = true;
	}
}
