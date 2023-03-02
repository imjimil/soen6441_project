package controller;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import model.Lease;
import model.Property;
import model.PropertyFactory;
import model.Tenant;
import utility.Constant;
import view.PropertyView;

public class Controller {
	private PropertyView propertyView;
	private Property propertyModel;
	public Controller(PropertyView propertyView, Property propertyModel) {
		this.propertyView = propertyView;
		this.propertyModel = propertyModel;
	}
	
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
			System.out.println("10. Display all leases");
			System.out.println("11. Display leases that will be ending");
			System.out.println("12. Display potential tenants and their units");
			System.out.println("13. Exit");
			System.out.print("Your choice:");
			int cmd = scanner.nextInt();
			switch (cmd){
			case 1:
				// Add a property
				PropertyFactory propertyFactory = new PropertyFactory();
				Map<String, ArrayList<Object>> inputPropertyData = propertyView.getPropertyInfo();
				for (Map.Entry<String, ArrayList<Object>> pair : inputPropertyData.entrySet()) {
					if("A".equals(pair.getKey())) {
						propertyModel = propertyFactory.createProperty(Constant.APARTMENT);
						properties.add(propertyModel.create(pair.getValue()));
					} else if ("C".equals(pair.getKey())) {
						propertyModel = propertyFactory.createProperty(Constant.CONDO);
						properties.add(propertyModel.create(pair.getValue()));
					} else if ("H".equals(pair.getKey())) {
						propertyModel = propertyFactory.createProperty(Constant.HOUSE);
						properties.add(propertyModel.create(pair.getValue()));
					}
				}
				
				break;
			case 2:
				// Add a tenants
				//ArrayList<Lease> LeaseNos = new ArrayList<>();
				//ArrayList<Property> InterestedProps = new ArrayList<>();
				ArrayList<Object> details = new ArrayList<>();
				System.out.println("Enter the Tenant Name:");
				scanner.nextLine();
				String tenantName = scanner.nextLine();
				details.add(tenantName);
				System.out.println("Enter the Tenant Phone No:");
				String phoneNo = scanner.nextLine();
				details.add(phoneNo);
				System.out.println("Enter the Tenant Email:");
				String emailID = scanner.nextLine();
				details.add(emailID);
				System.out.println("Enter the UnitNo Rented:");
				String unitNo = scanner.nextLine();
				details.add(unitNo);

				Tenant tenant = new Tenant();
				Tenant newTenant = tenant.create(details);
				tenants.add(newTenant);
				System.out.println("Tenant Added Successfully!");
				
				break;
			
			case 3:
				// Rent a unit 
				//so as i understand here i should display all availavle units and all tenets, then
				//ask user which unit he wants to rent and for which tenent, take that property object and tenet 
				//object and populate the info needed for lease 

				System.out.println("Here's the vacant properties.");
				if(properties.size() > 0) {
					propertyView.displayVacantProperty(properties);
				}
				System.out.println();
				System.out.println("Please enter property ID you want to rent.");

				int selectedPropertyID = scanner.nextInt();
				
				Property rentedPropertyObject = propertyView.getObjectByID(selectedPropertyID, properties);
				
				System.out.println();
				System.out.println("Now select which tenant is buying the property.");

				if(tenants.size() > 0) {
					for (int i = 0; i < tenants.size(); i++) {
						if(tenants.get(i).toString() != null) {
							System.out.println((i+1) +". "+tenants.get(i).display());
						}
					}
				} else {
					System.out.println("No tenants found.");
				}

				System.out.println("Enter ID of the Tenant");
				int selectedTenantID = scanner.nextInt();
				Tenant tnt = new Tenant();
				Tenant selectedTenantObject = tnt.getObjectByID(selectedTenantID, tenants);

				Lease lease = new Lease(selectedPropertyID, null, null, selectedTenantID, null, selectedTenantObject, rentedPropertyObject);
				System.out.println("perfect");
				leases.add(lease);				

				break;
			case 4:
				// Display tenants
				if(tenants.size() > 0) {
					for (int i = 0; i < tenants.size(); i++) {
						if(tenants.get(i).toString() != null) {
							System.out.println((i+1)+". " + tenants.get(i).display());
						}
					}
				} else {
					System.out.println("No tenants found.");
				}
				break;
			case 5:
				// Display properties
				if(properties.size() > 0) {
					propertyView.displayProperty(properties);
				} else {
					System.out.println("No properties found.");
				}				
				break;
			case 6:
				// Display vacant units
				if(properties.size() > 0) {
					propertyView.displayVacantProperty(properties);
				}
				break;
			case 7:
				// Display rented units
				if(properties.size() > 0) {
					propertyView.displayRantedProperty(properties);
				}
				break;
			case 8:
				// Display paid/not paid rent units
				if(leases.size() > 0) {
					System.out.println("Rent paid: ");

					for (int i = 0; i < leases.size(); i++) {
						if(leases.get(i).getIsRentPaid() == true) {
							System.out.println(leases.get(i).display());
						}
					}
					System.out.println("Rent Unpaid: ");
					for (int i = 0; i < leases.size(); i++) {
						if(leases.get(i).getIsRentPaid() != true) {
							System.out.println(leases.get(i).display());
						}
					}
				}
				else {
					System.out.println("No leases to show!");
				}
				break;
			case 9:
				// Express an interest in a unit
				
				break;
			case 10:
				// Display all leases
				if(leases.size() > 0) {
					for (int i = 0; i < leases.size(); i++) {
						System.out.println((i+1) + leases.get(i).display());
					}
				}
				else {
					System.out.println("No lease found!");
				}
				break;
			case 11:
				// Display leases that will be ending
				
				break;
			case 12:
				// Display potential tenants and their units
				
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
