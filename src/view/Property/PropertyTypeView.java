package view.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Property;
import view.AppBase;

/**
 * Project Phase 2
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishnan			- 40231724
 * 
 * PropertyView class
 */
public class PropertyTypeView extends Application implements AppBase {
	
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
	public void start(Stage primaryStage) throws Exception {
		AddPropertyView addPropertyView = new AddPropertyView();
		// Hold buttons in an HBox
		Button btnMainMenu = new Button("Main Menu");
		HBox hMainMenu = new HBox(btnMainMenu);

		Button btnAddApartment = new Button("Apartment");
		Button btnAddCondo = new Button("Condo");
		Button btnAddHouse = new Button("House");
		HBox hBoxProperty = new HBox(btnAddApartment, btnAddCondo, btnAddHouse);
		hBoxProperty.setSpacing(25);
		hBoxProperty.setPadding(new Insets(95, 12, 15, 12));
		hBoxProperty.setAlignment(Pos.CENTER);
		BorderPane borderPane = new BorderPane(new Pane());
		borderPane.setTop(hMainMenu);
		borderPane.setCenter(hBoxProperty);
		Scene scene = new Scene(borderPane, 500, 350);
		primaryStage.setTitle("Add a property"); // Set title
		primaryStage.setScene(scene);

		btnMainMenu.setOnAction(event -> {
			primaryStage.setTitle("Project Phase 2 Demo");
			primaryStage.setScene(propertyController.getPreScene());
		});
		btnAddApartment.setOnAction(e -> {
			primaryStage.setUserData("A");
			addPropertyView.start(primaryStage);
		});

		btnAddCondo.setOnAction(e -> {
			primaryStage.setUserData("C");
			addPropertyView.start(primaryStage);
		});

		btnAddHouse.setOnAction(e -> {
			primaryStage.setUserData("H");
			addPropertyView.start(primaryStage);
		});
	}
}
