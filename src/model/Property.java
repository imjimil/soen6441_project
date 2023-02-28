package model;


/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 *
 * Property class
 */

public abstract class Property implements IPropertyTenantLease {
	
	protected int numberOfBedRoom;
	
	protected int numberOfBathRoom;
	
	protected float squareFootage;
	
	protected String streetName;
	
	protected String city;
	
	protected String postalCode;
	
	protected Boolean status;
}
