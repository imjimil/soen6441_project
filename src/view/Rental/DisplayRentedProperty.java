package view.Rental;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Apartment;
import model.Condo;
import model.House;
import model.Property;
import utility.Constant;
import view.AppBase;

public class DisplayRentedProperty extends Application implements AppBase {

    public VBox displayRentedProperty(Stage primaryStage, ArrayList<Property> properties, int target) {
        Label lblPropertyType = new Label();
        Label lblCivicAddress = new Label();
        Label lblAptNo = new Label();
        Label lblStreetNo = new Label();
        Label lblUnitNo = new Label();
        VBox propertyInfoVBox = null;
        if (properties.size() > 0) {
            VBox propertyVBox = new VBox();
            propertyVBox.setSpacing(10);
    
            for (int i = 0; i < properties.size(); i++) {
                Property p = properties.get(i);
    
                if(p.getStatus() == false) {
                    Label lblTenantNumber = new Label("Property " + (i + 1) + ":");
                    lblTenantNumber.setFont(new Font(20));
                    Label lblPropertyID = new Label("ID: " + p.getID());
                    if(Constant.APARTMENT_CLASS_NAME.equals(p.getClass().getSimpleName())) {
                        lblPropertyType = new Label((i + 1) + ". Apartment");
                        lblPropertyType.setFont(new Font(20));
                        lblCivicAddress = new Label("Civic Address: " + ((Apartment) p).getCivicAddress());
                        lblAptNo = new Label("Apt no: " + ((Apartment)p).getAptNo());
                    }
                    if(Constant.CONDO_CLASS_NAME.equals(p.getClass().getSimpleName())) {
                        lblPropertyType = new Label((i + 1) + ". Condo");
                        lblPropertyType.setFont(new Font(20));
                        lblStreetNo = new Label("Street no: " + ((Condo) p).getStreetNo());
                        lblUnitNo = new Label("Unit no: " + ((Condo)p).getUnitNo());
                    }
                    if(Constant.HOUSE_CLASS_NAME.equals(p.getClass().getSimpleName())) {
                        lblPropertyType = new Label((i + 1) + ". House");
                        lblPropertyType.setFont(new Font(20));
                        lblStreetNo = new Label("Street no: " + ((House) p).getStreetNo());
                    }
                    Label lblBedRoom = new Label("Number of bed room: "+((Property) p).getNumberOfBedRoom());
                    Label lblBathRoom = new Label("Number of bath room: "+((Property) p).getNumberOfBedRoom());
                    Label lblSquareFootage = new Label("Square Footage: "+((Property) p).getSquareFootage());
                    Label lblStreetName = new Label("Street Name: "+((Property) p).getStreetName());
                    Label lblCity = new Label("City: "+((Property) p).getCity());
                    Label lblPostalCode = new Label("Postal Code: "+((Property) p).getPostalCode());
                    Label lblStatus = new Label("status: "+((Property) p).getStatus());

                    if(Constant.APARTMENT_CLASS_NAME.equals(p.getClass().getSimpleName())) {
                        propertyInfoVBox = new VBox(lblPropertyType, lblPropertyID, lblCivicAddress, lblAptNo, lblBedRoom, lblBathRoom, lblSquareFootage, lblStreetName, lblCity, lblPostalCode, lblStatus);
                    }
                    else if(Constant.CONDO_CLASS_NAME.equals(p.getClass().getSimpleName())) {
                        propertyInfoVBox = new VBox(lblPropertyType, lblPropertyID, lblStreetNo, lblUnitNo, lblBedRoom, lblBathRoom, lblSquareFootage, lblStreetName, lblCity, lblPostalCode, lblStatus);
                    }
                    else if(Constant.HOUSE_CLASS_NAME.equals(p.getClass().getSimpleName())) {
                        propertyInfoVBox = new VBox(lblPropertyType, lblPropertyID, lblStreetNo, lblBedRoom, lblBathRoom, lblSquareFootage, lblStreetName, lblCity, lblPostalCode, lblStatus);
                    }
                    propertyInfoVBox.setSpacing(5);
                    propertyInfoVBox.setPadding(new Insets(10));
        
                    propertyVBox.getChildren().add(propertyInfoVBox);
                }
                
            }

            if(target == 1) {
                    
                ScrollPane scrollPane = new ScrollPane(propertyVBox);
        
                // main menu button
                Button btnMainMenu = new Button("Main Menu");
                HBox hMainMenu = new HBox(btnMainMenu);
                btnMainMenu.setOnAction(event -> {
                    // go back to previous scene
                    primaryStage.setScene(propertyController.getPreScene());
                });
                Pane pMenu = new Pane();
                hMainMenu.setPadding(new Insets(20));
                pMenu.getChildren().add(hMainMenu);
        
                // Build scene
                BorderPane borderPropertyPane = new BorderPane();
                borderPropertyPane.setTop(scrollPane);
                borderPropertyPane.setBottom(pMenu);
                Scene vacantPropertyScene = new Scene(borderPropertyPane, 550, 550);
                primaryStage.setTitle("All Rented properties"); // Set title
                primaryStage.setScene(vacantPropertyScene);
            }
            else {
                return propertyVBox;
            }
        } 
        else {
            System.out.println("No vacant property.");
        }
        return null;
    }

    @Override
    public void start(Stage primaryStage) {
        ArrayList<Property> properties = propertyController.getProperties();
        displayRentedProperty(primaryStage, properties, 1);
    }
}
    

