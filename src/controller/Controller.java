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
				ArrayList<Lease> LeaseNos = new ArrayList<>();
				ArrayList<Property> InterestedProps = new ArrayList<>();
				System.out.println("Enter the Tenant Name:");
				scanner.nextLine();
				String tenantName = scanner.nextLine();
				System.out.println("Enter the Tenant Phone No:");
				String phoneNo = scanner.nextLine();
				System.out.println("Enter the Tenant Email:");
				String emailID = scanner.nextLine();
				System.out.println("Enter the UnitNo Rented:");
				String unitNo = scanner.nextLine();

				int id = tenants.size()+1;
				Tenant tnt = new Tenant(id,tenantName,phoneNo,emailID,unitNo,null, null );
				tenants.add(tnt);
				System.out.println("Tenant Added Successfully!");
				
				break;
			
			case 3:
				// Rent a unit
				
				break;
			case 4:
				// Display tenants
				if(tenants.size() > 0) {
					for (int i = 0; i < tenants.size(); i++) {
						if(tenants.get(i).toString() != null) {
							System.out.println(tenants.get(i).display());
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
				
				break;
			case 7:
				// Display rented units
				
				break;
			case 8:
				// Display paid/not paid rent units
				
				break;
			case 9:
				// Express an interest in a unit
				
				break;
			case 10:
				// Display all leases
				
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
