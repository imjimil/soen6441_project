package model;

import java.util.ArrayList;
import utility.PropertyType;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishnan			- 40231724
 * 
 * Condo class
 */
public class Condo extends Property {

	private int streetNo;
	
	private int unitNo;
	
	public Condo() {
	}

	public Condo(int streetNo, int unitNo, int numberOfBedRoom, int numberOfBathRoom,
			float squareFootage, String streetName, String city, String postalCode) {
		super(numberOfBedRoom, numberOfBathRoom, squareFootage, streetName, city, postalCode);
		this.streetNo = streetNo;
		this.unitNo = unitNo;
	}

	public int getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	public int getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(int unitNo) {
		this.unitNo = unitNo;
	}

	@Override
	public String display() {
		return PropertyType.CONDO + ", ID- "+propertyID + ", Street No:" + this.streetNo + ", Unit No: " + this.unitNo + ", No.BedRoom: " + this.numberOfBedRoom + ""
				+ ", No.BathRoom: " + this.numberOfBathRoom + ", squareFootage: " + this.squareFootage + ", StreetName: " + this.streetName + ", City: " + this.city + ", postalCode: " + this.postalCode + ", Owner- " + ((this.tenent) != null ? this.tenent.getTenantName() : "null")  +", status- "+status+"\n";
	}

	public String displayVacant() {
		if(status) {
			return display();
		}
		
		return "";
	}

	public String displayRented() {
		if(!status) {
			return display();
		}
		
		return "";
	}

	@Override
	public Condo create(ArrayList<Object> data) {
		// Add a new condo
		if(data.size() > 0) {
			int numberOfBedRoom = (int) data.get(0);
			int numberOfBathRoom = (int) data.get(1);
			float squareFootage = (float) data.get(2);
			String streetName = (String) data.get(3);
			String city = (String) data.get(4);
			String postalCode = (String) data.get(5);
			int streetNo = (int) data.get(6);
			int unitNo = (int) data.get(7);
			Condo condo = new Condo(streetNo, unitNo, numberOfBedRoom, numberOfBathRoom, squareFootage, streetName, city, postalCode);
			
			return condo;
		}
		
		return null;
	}

}
