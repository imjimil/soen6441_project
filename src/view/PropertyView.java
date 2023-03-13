package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Property;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishan			- 40231724
 * 
 * PropertyView class
 */
public class PropertyView {
	
	public Map<String, ArrayList<Object>> getPropertyInfo() {
		Scanner scanner = new Scanner(System.in);
		Map<String, ArrayList<Object>> result = new HashMap<>();
		// Add a property
		System.out.println("Enter property type (A for Apartment, C for Condo, H for House):");
//		scanner.nextLine();
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
		
		if("A".equals(propertyType)) {
			System.out.println("Enter civic address:");
			String civicAddress = scanner.nextLine();
			System.out.println("Enter apt No:");
			int aptNo = scanner.nextInt();
			propertyData.add(civicAddress);
			propertyData.add(aptNo);
			
			
			result.put("A", propertyData);
		} else if ("C".equals(propertyType)) {
			System.out.println("Enter Street No:");
			int streetNo = scanner.nextInt();
			System.out.println("Enter Unit No:");
			int unitNo = scanner.nextInt();
			propertyData.add(streetNo);
			propertyData.add(unitNo);
			
			result.put("C", propertyData);
		} else if ("H".equals(propertyType)) {
			System.out.println("Enter Street No:");
			int streetNo = scanner.nextInt();
			propertyData.add(streetNo);
			result.put("H", propertyData);
		}
		
		return result;
	}
	
	public void displayProperty(ArrayList<Property> properties) {
		for (int i = 0; i < properties.size(); i++) {
			if(properties.get(i).toString() != null) {
				System.out.println(i+1 + ". " + properties.get(i).display());
			}
		}
    }

	public String displayVacantProperty(ArrayList<Property> properties) {
		String output = "";
		for (int i = 0; i < properties.size(); i++) {
			output = output.concat(properties.get(i).displayVacant());
		}
		if(output.isEmpty()) {
			System.out.println("No vacant properties found!");
		} else {
			System.out.println(output);
		}
		
		return output;
	}

	public String displayRentedProperty(ArrayList<Property> properties) {
		String output = "";
		for (int i = 0; i < properties.size(); i++) {
			output = output.concat(properties.get(i).displayRented());
		}
		if(output.isEmpty()) {
			System.out.println("No rented properties found!");
		} else {
			System.out.println(output);
		}
		
		return output;
	}

	public Property getObjectByID(int ID, ArrayList<Property> properties) {
		for (Property property : properties) {
			if(property.getID() == ID) {
				return property;
			}
		}
		return null;
	}
}
