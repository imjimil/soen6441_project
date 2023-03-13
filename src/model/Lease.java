package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishnan			- 40231724
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
		return "Lease No-"+ this.leaseNo + ", Start Date- "+ this.leaseStartDate + ", End Date- "+ this.leaseEndDate 
		+", Rent- "+ this.rentAmount + ", Rent paid- "+ this.isRentPaid + ", Tenant- "+ this.tenantInfo.getTenantName() +"\n"+" Property info- " + this.propertyInfo.getID();
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

	public void getPaidOrNotPaidRentProperty(ArrayList<Lease> leases) {
		try{
			System.out.println("Rent Paid: ");
			for (int i = 0; i < leases.size(); i++) {
				if(leases.get(i).getIsRentPaid() == true) {
					System.out.println((i+1) + ". " + leases.get(i).display());
				}
			}
			System.out.println("Unpaid Rent: ");
			for (int i = 0; i < leases.size(); i++) {
				if(leases.get(i).getIsRentPaid() != true) {
					System.out.println((i+1) + ". " + leases.get(i).display());
				}
			}
		}catch(Exception e){
			System.out.println("An error occurred,please try again!!!");
		}
	}

	public String getAllLeases(ArrayList<Lease> leases) {
		String output = "";
		try{
			for (int i = 0; i < leases.size(); i++) {
				output = output.concat((i+1) +". "+ leases.get(i).display());
			}
			if(output.isEmpty()) {
				System.out.println("No leases found.");
			} else {
				System.out.println(output);
			}

			return output;
		}catch(Exception e){
			System.out.println("An error occurred,please try again!!!");
			return "";
		}
	}

	public void getEndingLeases(ArrayList<Lease> leases) {
		LocalDateTime now = LocalDateTime.now();

		LocalDate startThisMonth = LocalDate.of(now.getYear(), now.getMonth(), 1);
		LocalDate endThisMonth = startThisMonth.with(TemporalAdjusters.lastDayOfMonth());
		LocalDate startNextMonth = startThisMonth.plusMonths(1);
		LocalDate endNextMonth = startNextMonth.with(TemporalAdjusters.lastDayOfMonth());

		try{
			for (Lease obj : leases) {
				Date endDate = obj.getLeaseEndDate();
				LocalDateTime endDateTime = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				if ((endDateTime.isAfter(startThisMonth.atStartOfDay()) && endDateTime.isBefore(endThisMonth.plusDays(1).atStartOfDay())) ||
					(endDateTime.isAfter(startNextMonth.atStartOfDay()) && endDateTime.isBefore(endNextMonth.plusDays(1).atStartOfDay()))) {
						System.out.println(obj.display());
				}
			}
		}catch(Exception e){
			System.out.println("An error occurred,please try again!!!");
		}
	}

}
