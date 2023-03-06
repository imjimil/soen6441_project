package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 * 
 * Lease class
 */
public class Lease implements ITenantLease {

	private int leaseNo;
	
	private Date leaseStartDate;
	
	private Date leaseEndDate;
	
	private float rentAmount;
	
	private Boolean isRentPaid;
	
	private Tenant tenantInfo;

	private Property propertyInfo;
	
	public int getLeaseNo() {
		return leaseNo;
	}

	public void setLeaseNo(int leaseNo) {
		this.leaseNo = leaseNo;
	}

	public Date getLeaseStartDate() {
		return leaseStartDate;
	}

	public void setLeaseStartDate(Date leaseStartDate) {
		this.leaseStartDate = leaseStartDate;
	}

	public Date getLeaseEndDate() {
		return leaseEndDate;
	}

	public void setLeaseEndDate(Date leaseEndDate) {
		this.leaseEndDate = leaseEndDate;
	}

	public float getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(float rentAmount) {
		this.rentAmount = rentAmount;
	}

	public Boolean getIsRentPaid() {
		return isRentPaid;
	}

	public void setIsRentPaid(Boolean isRentPaid) {
		this.isRentPaid = isRentPaid;
	}

	public Tenant getTenantInfo() {
		return tenantInfo;
	}

	public void setTenantInfo(Tenant tenantInfo) {
		this.tenantInfo = tenantInfo;
	}

	public Lease(int leaseNo, Date leaseStartDate, Date leaseEndDate, int rentAmount, Boolean isRentPaid,
			Tenant tenantInfo, Property propertyInfo) {
		super();
		this.leaseNo = leaseNo;
		this.leaseStartDate = leaseStartDate;
		this.leaseEndDate = leaseEndDate;
		this.rentAmount = rentAmount;
		this.isRentPaid = isRentPaid;
		this.tenantInfo = tenantInfo;
		this.propertyInfo = propertyInfo;
	}
	
	public Lease() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String display() {
		return "Lease No-"+ leaseNo + ", Start Date- "+ leaseStartDate + ", End Date- "+ leaseEndDate 
		+", Rent- "+ rentAmount + ", Rent paid- "+ isRentPaid + ", Tenant- "+ tenantInfo.getTenantName() +"\n"+" Property info- " + propertyInfo.getID();
	}

	@Override
	public Lease create(ArrayList<Object> data) {
		if(data.size() > 0) {
			int leaseNumber = new Random().nextInt(90000) + 10000;
			Date start = (Date) data.get(0);
			Date end = (Date) data.get(1);
			int totalRent = (int) data.get(2);
			Boolean rentStatus = (Boolean) data.get(3);
			Tenant tenantInfo = (Tenant) data.get(4);
			Property propertyInfo = (Property) data.get(5);
			Lease lease = new Lease(leaseNumber, start, end, totalRent, rentStatus, tenantInfo, propertyInfo);
			
			return lease;
		}
		
		return null;
	}

}
