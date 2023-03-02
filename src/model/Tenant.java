package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 * 
 * Tenant class
 */
public class Tenant implements ITenantLease {

	private int tenantId;
	
	private String tenantName;
	
	private String tenantPhone;
	
	private String tenantEmail;
	
	private String unitRented;
	
	private ArrayList<Lease> leases;
	
	private ArrayList<Property> interestedUnits;
	
	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}
	
	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getTenantPhone() {
		return tenantPhone;
	}

	public void setTenantPhone(String tenantPhone) {
		this.tenantPhone = tenantPhone;
	}

	public String getTenantEmail() {
		return tenantEmail;
	}

	public void setTenantEmail(String tenantEmail) {
		this.tenantEmail = tenantEmail;
	}

	public String getUnitRented() {
		return unitRented;
	}

	public void setUnitRented(String unitRented) {
		this.unitRented = unitRented;
	}
	
	public ArrayList<Lease> getLeases() {
		return leases;
	}

	public void setLeases(ArrayList<Lease> leases) {
		this.leases = leases;
	}

	public ArrayList<Property> getInterestedUnits() {
		return interestedUnits;
	}

	public void setInterestedUnits(ArrayList<Property> interestedUnits) {
		this.interestedUnits = interestedUnits;
	}

	public int getID() {
		return tenantId;
	}
	
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tenant(String tenantName, String tenantPhone, String tenantEmail, String unitRented,
			ArrayList<Lease> leases, ArrayList<Property> interestedUnits) {
		super();
		this.tenantId = new Random().nextInt(90000) + 10000;
		this.tenantName = tenantName;
		this.tenantPhone = tenantPhone;
		this.tenantEmail = tenantEmail;
		this.unitRented = unitRented;
		this.leases = leases;
		this.interestedUnits = interestedUnits;
	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		return "- tenant ID:" + this.tenantId + ", tenantName: " + this.tenantName + ""
				+ ", tenantPhone: " + this.tenantPhone + ", tenantEmail: " + this.tenantEmail
				+ ", unitRented: " + this.unitRented + ", leases: " + this.leases + ", interestedUnits: "
				+ this.interestedUnits;
	}

	public Tenant getObjectByID(int ID, ArrayList<Tenant> tenant) {
		for (Tenant tnt : tenant) {
			if(tnt.getID() == ID) {
				return tnt;
			}
		}
		return null;
	}

	@Override
	public Tenant create(ArrayList<Object> data) {
		String tName = (String) data.get(0);
		String tPhone = (String) data.get(1);
		String temail = (String) data.get(2);
		String unitRented = (String) data.get(3); //Anitha do change this later, i've did this for working purpose.

		Tenant tenant = new Tenant(tName, tPhone, temail, unitRented, null, null);
		
		return tenant;
	}

}
