package model;

import java.util.ArrayList;

import utility.Constant;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 * 
 * House class
 */
public class House extends Property {
	
	private int streetNo;
	
	public House() {
	}

	public House(int streetNo, int numberOfBedRoom, int numberOfBathRoom,
			float squareFootage, String streetName, String city, String postalCode) {
		super(numberOfBedRoom, numberOfBathRoom, squareFootage, streetName, city, postalCode);
		this.streetNo = streetNo;
	}

	public int getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}


	@Override
	public String display() {
		return Constant.HOUSE + ", ID- "+propertyID + ", Street No:" + this.streetNo + ", No.BedRoom: " + this.numberOfBedRoom + ""
				+ ", No.BathRoom: " + this.numberOfBathRoom + ", squareFootage: " + this.squareFootage + ", StreetName: " + this.streetName + ", City: " + this.city + ", postalCode: " + this.postalCode +"status- "+status;
	}

	public String displayVacant() {
		if(status==true) {
			return display();
		}
		else {
			return "No Vacant Properties";
		}
	}

	public String displayRented() {
		if(status==false) {
			return display();
		}
		else {
			return "No Ranted Properties";
		}	
	}

	@Override
	public House create(ArrayList<Object> data) {
		// Add a new house
		if(data.size() > 0) {
			int numberOfBedRoom = (int) data.get(0);
			int numberOfBathRoom = (int) data.get(1);
			float squareFootage = (float) data.get(2);
			String streetName = (String) data.get(3);
			String city = (String) data.get(4);
			String postalCode = (String) data.get(5);
			int streetNo = (int) data.get(6);
			House house = new House(streetNo, numberOfBedRoom, numberOfBathRoom, squareFootage, streetName, city, postalCode);
			
			return house;
		}
		
		return null;
	}

}
