package model;

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
		super();
		// TODO Auto-generated constructor stub
	}

	public House(int streetNo) {
		super();
		this.streetNo = streetNo;
	}

	public int getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
