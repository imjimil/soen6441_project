package model;

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
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment(String civicAddress, int aptNo) {
		super();
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
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
