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
	
	public ArrayList<Lease> getLeases() {
		return leases;
	}

	public void setLeases(Lease l) {
		this.leases.add(l);
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

	public Tenant(String tenantName, String tenantPhone, String tenantEmail,
			ArrayList<Lease> leases, ArrayList<Property> interestedUnits) {
		super();
		this.tenantId = new Random().nextInt(90000) + 10000;
		this.tenantName = tenantName;
		this.tenantPhone = tenantPhone;
		this.tenantEmail = tenantEmail;
		this.leases = new ArrayList<>();
		this.interestedUnits = new ArrayList<>();
	}

	@Override
	public String display() {
		// TODO Auto-generated method stub
		return "- tenant ID:" + this.tenantId + ", tenantName: " + this.tenantName + ""
				+ ", tenantPhone: " + this.tenantPhone + ", tenantEmail: " + this.tenantEmail
				+ ", leases: " + this.showLeases(leases) + ", interestedUnits: "
				+ this.interestedUnits;
	}

	public ArrayList<Integer> showLeases(ArrayList<Lease> lease) {
		ArrayList<Integer> result = new ArrayList<>(); 
		for (Lease leaseInfo : lease) {
			result.add(leaseInfo.getLeaseNo());
		}
		return result;
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

		Tenant tenant = new Tenant(tName, tPhone, temail, null, null);
		
		return tenant;
	}

}
