package model;

import java.util.ArrayList;

import utility.Constant;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 * 
 * Apartment class
 */
public class Apartment extends Property {

	private String civicAddress;
	
	private int aptNo;
	
	public Apartment() {
	}

	public Apartment(String civicAddress, int aptNo, int numberOfBedRoom, int numberOfBathRoom,
			float squareFootage, String streetName, String city, String postalCode) {
		super(numberOfBedRoom, numberOfBathRoom, squareFootage, streetName, city, postalCode);
		this.civicAddress = civicAddress;
		this.aptNo = aptNo;
	}

	public String getCivicAddress() {
		return civicAddress;
	}

	public void setCivicAddress(String civicAddress) {
		this.civicAddress = civicAddress;
	}

	public int getAptNo() {
		return aptNo;
	}

	public void setAptNo(int aptNo) {
		this.aptNo = aptNo;
	}

	@Override
	public String display() {
		return Constant.APARTMENT + "- Civic Address:" + this.civicAddress + ", Apt No: " + this.aptNo + ", No.BedRoom: " + this.numberOfBedRoom + ""
				+ ", No.BathRoom: " + this.numberOfBathRoom + ", squareFootage: " + this.squareFootage + ", StreetName: " + this.streetName + ", City: " + this.city + ", postalCode: " + this.postalCode;
	}

	@Override
	public Apartment create(ArrayList<Object> data) {
		// Add a new apartment
		if(data.size() > 0) {
			int numberOfBedRoom = (int) data.get(0);
			int numberOfBathRoom = (int) data.get(1);
			float squareFootage = (float) data.get(2);
			String streetName = (String) data.get(3);
			String city = (String) data.get(4);
			String postalCode = (String) data.get(5);
			String civicAddress = (String) data.get(6);
			int aptNo = (int) data.get(7);
			Apartment apartment = new Apartment(civicAddress, aptNo, numberOfBedRoom, numberOfBathRoom, 
					squareFootage, streetName, city, postalCode);
			
			return apartment;
		}
		
		return null;
	}

}
