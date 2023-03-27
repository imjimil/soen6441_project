package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import controller.PropertyController;
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

/**
 * Project Phase 2
 * Student 1: 	Quoc Phong Ngo 				- 40230574
 * Student 2: 	Jimil Suchitkumar Prajapati - 40205477
 * Student 3:   Anitha Ramakrishnan			- 40231724
 * 
 * PropertyView class
 */
public class PropertyView extends Application implements AppBase {
	
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
		Map<String, ArrayList<Object>> result = new HashMap<>();
		ArrayList<Object> propertyData = new ArrayList<Object>();
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
//			hBoxProperty.setVisible(false);
			Label statusMessage = new Label();
			HBox hStatus = new HBox(statusMessage);

			Text txtCivicAddress = new Text(80, 80, "Civic address: *");
			TextField tfCivicAddress = new TextField();
			HBox hCivicAddress = new HBox(txtCivicAddress, tfCivicAddress);

			Text txtAptNo = new Text(80, 80, "Apt No: *");
			TextField tfAptNo = new TextField();
			HBox hAptNo = new HBox(txtAptNo, tfAptNo);

			Text txtNoBedRoom = new Text(80, 80, "Number of bed room:");
			TextField tfNoBedRoom = new TextField();
			HBox hBedRoom = new HBox(txtNoBedRoom, tfNoBedRoom);
			Text txtNoBathRoom = new Text(80, 80, "Number of bath room:");
			TextField tfNoBathRoom = new TextField();
			HBox hBathRoom = new HBox(txtNoBathRoom, tfNoBathRoom);

			Text txtFootage = new Text(80, 80, "Square Footage:");
			TextField tfFootage = new TextField();
			HBox hFootage = new HBox(txtFootage, tfFootage);

			Text txtStreetName = new Text(80, 80, "Street Name:");
			TextField tfStreetName = new TextField();
			HBox hStreet = new HBox(txtStreetName, tfStreetName);

			Text txtCity = new Text(80, 80, "City:");
			TextField tfCity = new TextField();
			HBox hCity = new HBox(txtCity, tfCity);

			Text txtPostalCode = new Text(80, 80, "Postal Code:");
			TextField tfPostalCode = new TextField();
			HBox hPostalCode = new HBox(txtPostalCode, tfPostalCode);

			Button btnSubmit = new Button("Submit");
			VBox vBoxProperty = new VBox(hMainMenu, hStatus, hCivicAddress, hAptNo, hBedRoom, hBathRoom,
					hFootage, hStreet, hCity, hPostalCode, btnSubmit);
			vBoxProperty.setSpacing(25);
			vBoxProperty.setPadding(new Insets(95, 12, 15, 12));
			vBoxProperty.setAlignment(Pos.CENTER);
			Pane addPropertyPane = new Pane();
			// Hold buttons in an HBox
			BorderPane borderPropertyPane = new BorderPane(addPropertyPane);
			borderPropertyPane.setTop(vBoxProperty);
			Scene apartmentScene = new Scene(borderPropertyPane, 500, 350);
			primaryStage.setTitle("Add an apartment"); // Set title
			primaryStage.setScene(apartmentScene);

			btnSubmit.setOnAction(event -> {
				propertyData.add(Integer.parseInt(tfNoBedRoom.getText()));
				propertyData.add(Integer.parseInt(tfNoBathRoom.getText()));
				propertyData.add(Float.parseFloat(tfFootage.getText()));
				propertyData.add(tfStreetName.getText());
				propertyData.add(tfCity.getText());
				propertyData.add(tfPostalCode.getText());
				propertyData.add(tfCivicAddress.getText());
				propertyData.add(Integer.parseInt(tfAptNo.getText()));
				result.put("A", propertyData);

				PropertyController propertyController = new PropertyController();
				boolean returnResult = propertyController.addNewProperty(result);
				if(returnResult) {
					statusMessage.setText("Added new property successfully!");
					statusMessage.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
				}
			});
		});
//
	}
}
