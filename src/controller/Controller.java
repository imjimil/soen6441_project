package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Property;
import model.PropertyFactory;
import utility.Constant;

public class Controller {
	
	public void mainFunction() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Property> properties = new ArrayList<>();
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
				System.out.println("Enter property type (A for Apartment, C for Condo, H for House):");
				scanner.nextLine();
				String propertyType = scanner.nextLine();				
				System.out.println("Enter number of bed room:");
				int numberOfBedRoom = scanner.nextInt();
				System.out.println("Enter number of bath room:");
				int numberOfBathRoom = scanner.nextInt();
				System.out.println("Enter square footage:");
				scanner.nextLine();
				Float squareFootage = scanner.nextFloat();
				System.out.println("Enter street name:");
				scanner.nextLine();
				String streetName = scanner.nextLine();
				System.out.println("Enter city:");
				String city = scanner.nextLine();
				System.out.println("Enter postal code:");
				String postalCode = scanner.nextLine();
				
				ArrayList<Object> propertyData = new ArrayList<Object>();
				propertyData.add(numberOfBedRoom);
				propertyData.add(numberOfBathRoom);
				propertyData.add(squareFootage);
				propertyData.add(streetName);
				propertyData.add(city);
				propertyData.add(postalCode);
				
				PropertyFactory propertyFactory = new PropertyFactory();
				if("A".equals(propertyType)) {
					System.out.println("Enter civic address:");
					String civicAddress = scanner.nextLine();
					System.out.println("Enter apt No:");
					int aptNo = scanner.nextInt();
					propertyData.add(civicAddress);
					propertyData.add(aptNo);
					
					Property apartment = propertyFactory.createProperty(Constant.APARTMENT);
					properties.add(apartment.create(propertyData));
				} else if ("C".equals(propertyType)) {
					System.out.println("Enter Street No:");
					int streetNo = scanner.nextInt();
					System.out.println("Enter Unit No:");
					int unitNo = scanner.nextInt();
					propertyData.add(streetNo);
					propertyData.add(unitNo);
					
					Property condo = propertyFactory.createProperty(Constant.CONDO);
					properties.add(condo.create(propertyData));
				} else if ("H".equals(propertyType)) {
					System.out.println("Enter Street No:");
					int streetNo = scanner.nextInt();
					propertyData.add(streetNo);
					
					Property house = propertyFactory.createProperty(Constant.HOUSE);
					properties.add(house.create(propertyData));
				}
				break;
			case 2:
				// Add a tenant
				
				break;
			
			case 3:
				// Rent a unit
				
				break;
			case 4:
				// Display tenants
				
				break;
			case 5:
				// Display properties
				if(properties.size() > 0) {
					for (int i = 0; i < properties.size(); i++) {
						if(properties.get(i).toString() != null) {
							System.out.println(i+1 + ". " + properties.get(i).display());
						}
					}
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
