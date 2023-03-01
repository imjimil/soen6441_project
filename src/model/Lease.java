package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 * 
 * Lease class
 */
public class Lease implements ITenantLease {

	private String leaseNo;
	
	private Date leaseStartDate;
	
	private Date leaseEndDate;
	
	private Float rentAmount;
	
	private Boolean isRentPaid;
	
	private Tenant tenantInfo;
	
	public String getLeaseNo() {
		return leaseNo;
	}

	public void setLeaseNo(String leaseNo) {
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

	public Float getRentAmount() {
		return rentAmount;
	}

	public void setRentAmount(Float rentAmount) {
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

	public Lease(String leaseNo, Date leaseStartDate, Date leaseEndDate, Float rentAmount, Boolean isRentPaid,
			Tenant tenantInfo) {
		super();
		this.leaseNo = leaseNo;
		this.leaseStartDate = leaseStartDate;
		this.leaseEndDate = leaseEndDate;
		this.rentAmount = rentAmount;
		this.isRentPaid = isRentPaid;
		this.tenantInfo = tenantInfo;
	}
	
	public Lease() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

	@Override
	public Lease create(ArrayList<Object> data) {
		Lease lease = new Lease();
		
		return lease;
	}

}
