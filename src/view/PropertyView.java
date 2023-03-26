package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.application.Application;
import model.Property;

/**
 * Project Phase 1
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishnan			- 40231724
 * 
 * PropertyView class
 */
public class PropertyView extends Application {
	
	public Map<String, ArrayList<Object>> getPropertyInfo() {
		Scanner scanner = new Scanner(System.in);
		Map<String, ArrayList<Object>> result = new HashMap<>();
		try{
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
	}catch(Exception e){
		System.out.println("An error occurred,please try again!!!");
		return null;
	}
	}
	
	public void displayProperty(ArrayList<Property> properties) {
		try{
		for (int i = 0; i < properties.size(); i++) {
			if(properties.get(i).toString() != null) {
				System.out.println(i+1 + ". " + properties.get(i).display());
			}
		}
		}catch(Exception e){
			System.out.println("An error occurred,please try again!!!");
		}
    }

	public String displayVacantProperty(ArrayList<Property> properties) {
		String output = "";
		try{
			for (int i = 0; i < properties.size(); i++) {
				output = output.concat(properties.get(i).displayVacant());
			}
			if(output.isEmpty()) {
				System.out.println("No vacant properties found!");
			} else {
				System.out.println(output);
			}
			return output;
		}catch(Exception e){
			System.out.println("An error occurred,please try again!!!");
			return "";
		}
	}

	public String displayRentedProperty(ArrayList<Property> properties) {
		String output = "";
		try{
			for (int i = 0; i < properties.size(); i++) {
				output = output.concat(properties.get(i).displayRented());
			}
			if(output.isEmpty()) {
				System.out.println("No rented properties found!");
			} else {
				System.out.println(output);
			}
			return output;
		}catch(Exception e){
			System.out.println("An error occurred,please try again!!!");
			return "";
		}
	}

	public Property getObjectByID(int ID, ArrayList<Property> properties) {
		for (Property property : properties) {
			if(property.getID() == ID) {
				return property;
			}
		}
		return null;
	}

	@Override
	public void start(Stage stageThree) throws Exception {
		Text txtCivicAddress = new Text(80, 80, "Civic address:");
		TextField txtAptNo = new TextField();
		HBox h1 = new HBox(txtCivicAddress, txtAptNo);
		
		Button btnSubmit = new Button("Submit");
		VBox hBoxProperty = new VBox(h1, btnSubmit);
	    hBoxProperty.setSpacing(25);
	    hBoxProperty.setPadding(new Insets(95, 12, 15, 12));
	    hBoxProperty.setAlignment(Pos.CENTER);
		Pane addPropertyPane = new Pane();
	    // Hold buttons in an HBox
	    
		BorderPane borderPropertyPane = new BorderPane(addPropertyPane);
	    borderPropertyPane.setTop(hBoxProperty);
		Scene apartmentScene = new Scene(borderPropertyPane, 500, 350);
		stageThree.setTitle("Add an apartment"); // Set title
	    stageThree.setScene(apartmentScene); // Place the scene in the stage
	    stageThree.show(); // Display the stage
	}
}
