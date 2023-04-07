package controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import model.Lease;
import model.Property;
import model.PropertyFactory;
import model.Tenant;
import utility.PropertyType;
import view.Property.PropertyTypeView;
import view.RentalView;
//import view.TenantView;

public class Controller {
	private PropertyTypeView propertyTypeView;
//	private TenantView tenantView;
	private RentalView rentalView;
	private Property propertyModel;
	private Tenant tenantModel;

//	public Controller(PropertyTypeView propertyTypeView, TenantView tenantView, RentalView rentalView, Property propertyModel, Tenant tenantModel) {
//		this.propertyTypeView = propertyTypeView;
//		this.propertyModel = propertyModel;
//		this.tenantView = tenantView;
//		this.rentalView = rentalView;
//		this.tenantModel = tenantModel;
//	}
	
	public void mainFunction() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Property> properties = new ArrayList<>();
		ArrayList<Tenant> tenants = new ArrayList<>();
		ArrayList<Lease> leases = new ArrayList<>();

		while(true) {
			System.out.println("--------------------------");
			System.out.println("1.  Add a property");
			System.out.println("2.  Add a tenant");
			System.out.println("3.  Rent a unit");
			System.out.println("4.  Display tenants");
			System.out.println("5.  Display properties");
			System.out.println("6.  Display vacant units");
			System.out.println("7.  Display rented units");
			System.out.println("8.  Display paid/not paid rent units");
			System.out.println("9.  Express an interest in a unit");
			System.out.println("10. Display potential tenants and their units");
			System.out.println("11. Display leases that will be ending");
			System.out.println("12. Display all leases");
			System.out.println("13. Exit");
			System.out.print("Your choice:");
			int cmd = scanner.nextInt();
			switch (cmd){
			case 1:
				// Add a property
//				PropertyFactory propertyFactory = new PropertyFactory();
				Map<String, ArrayList<Object>> inputPropertyData = propertyTypeView.getPropertyInfo();
				for (Map.Entry<String, ArrayList<Object>> pair : inputPropertyData.entrySet()) {
					if("A".equals(pair.getKey())) {
						propertyModel = PropertyFactory.createProperty(PropertyType.APARTMENT);
						properties.add(propertyModel.create(pair.getValue()));
					} else if ("C".equals(pair.getKey())) {
						propertyModel = PropertyFactory.createProperty(PropertyType.CONDO);
						properties.add(propertyModel.create(pair.getValue()));
					} else if ("H".equals(pair.getKey())) {
						propertyModel = PropertyFactory.createProperty(PropertyType.HOUSE);
						properties.add(propertyModel.create(pair.getValue()));
					}
				}
				
				break;
			case 2:
				// Add a tenant
				ArrayList<Object> tenantInfo = new ArrayList<>();
//				tenantInfo = tenantView.getTenantInfo();
				Tenant tenant = new Tenant();
				Tenant newTenant = tenant.create(tenantInfo);
				tenants.add(newTenant);
				System.out.println("Tenant Added Successfully!");
				
				break;
			
			case 3:
				// Rent a unit 
				
				ArrayList<Object> userInput = new ArrayList<>();
				userInput = rentalView.askBasicInfo(properties, propertyTypeView, tenants);
				ArrayList<Object> savedInfo = (ArrayList<Object>) userInput.get(0);
				int selectedPropertyID = (int) userInput.get(1);
				int selectedTenantID = (int) userInput.get(2);


				Property selectedPropertyObject = propertyTypeView.getObjectByID(selectedPropertyID, properties);
				
				Tenant tnt = new Tenant();
				Tenant selectedTenantObject = tnt.getObjectByID(selectedTenantID, tenants);

				savedInfo.add(selectedTenantObject);
				savedInfo.add(selectedPropertyObject);
				Lease lease = new Lease();
				Lease addedLease = lease.create(savedInfo);
				System.out.println("Perfect!");
				leases.add(addedLease);

				//now add that lease to tenant object field.
				selectedTenantObject.setLeases(addedLease);
				//make property unavailable
				selectedPropertyObject.setStatus(false);
				selectedPropertyObject.setTenent(selectedTenantObject);
				break;
			case 4:
				// Display tenants
				if(tenants.size() > 0) {
//					tenantView.displayAllTenants(tenants);
				} else {
					System.out.println("No tenants found.");
				}
				break;
			case 5:
				// Display properties
				if(properties.size() > 0) {
					propertyTypeView.displayProperty(properties);
				} else {
					System.out.println("No properties found.");
				}				
				break;
			case 6:
				// Display vacant units
				if(properties.size() > 0) {
					propertyTypeView.displayVacantProperty(properties);
				}
				break;
			case 7:
				// Display rented units
				if(properties.size() > 0) {
					propertyTypeView.displayRentedProperty(properties);
				}
				break;
			case 8:
				// Display paid/not paid rent units
				if(leases.size() > 0) {
					Lease getLeases = new Lease();
					getLeases.getPaidOrNotPaidRentProperty(leases);
				}
				else {
					System.out.println("No leases to show!");
				}
				break;
			case 9:
				// Express an interest in a unit
//				String interestedData = tenantView.interestedInAUnit(properties, tenants);
//				tenantModel.interestedInAUnit(interestedData, tenants, properties);
				
				break;
			case 10:
				// Display potential tenants and their units
				tenantModel.displayPotentialTenants();
				break;
			case 11:
				// Display leases that will be ending
				if(leases.size() > 0) {
					Lease getLease = new Lease();
					getLease.getEndingLeases(leases);
				}
				else {
					System.out.println("No leases to Show!");
				}

				break;
			case 12:
				// Display all leases
				if(leases.size() > 0) {
					Lease getLease = new Lease();
					getLease.getAllLeases(leases);
				}
				else {
					System.out.println("No lease found!");
				}
				break;
			case 13:
				// Exit
				scanner.close();
				System.out.println("Exiting...");
				return;
				
			default:
				System.out.println("Enter right value");
			}
		}
	}
}
