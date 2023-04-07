package view.Tenant;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;
import utility.Constant;
import view.AppBase;

import java.util.ArrayList;

public class DisplayPotentialTenantsView extends Application implements AppBase {
    private String text = "";
    public ArrayList<VBox> buildScene(ArrayList<Property> properties, int target,
                                      Button btnRefresh, Stage secondStage) {
        HBox hTotal;
        HBox hID = null;
        HBox hCivicAddress = null;
        HBox hAptNo = null;
        HBox hStreetNo = null;
        HBox hUnitNo = null;
        HBox hBedRoom;
        HBox hBathRoom;
        HBox hFootage;
        HBox hStreet;
        HBox hCity;
        HBox hPostalCode;
        Label lblHeader;
        Label lblTotal = new Label();
        text = "Total properties: " + properties.size();
        lblTotal.setText(text);
        hTotal = new HBox(lblTotal);

        HBox hHeader;
        HBox hRefresh = new HBox(btnRefresh);
        FlowPane fpanes = new FlowPane();
        VBox vBoxProperty = null;
        ArrayList<VBox> vBoxArray = new ArrayList<>();
        for (int i = 0; i < properties.size(); i++) {
            lblHeader = new Label();
            Text txtPropertyID = new Text(180, 180, "ID: " + (properties.get(i)).getID());
            hID = new HBox(txtPropertyID);
            hID.setSpacing(10);
            if(Constant.APARTMENT_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                lblHeader.setText(i+1 + ". " + Constant.APARTMENT_CLASS_NAME);
                Text txtCivicAddress = new Text(180, 180, "Civic address: " + ((Apartment) properties.get(i)).getCivicAddress());
                hCivicAddress = new HBox(txtCivicAddress);

                Text txtAptNo = new Text(80, 80, "Apt No: "+((Apartment) properties.get(i)).getAptNo());
                hAptNo = new HBox(txtAptNo);
            } 
            else if(Constant.CONDO_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                lblHeader.setText(i+1 + ". " + Constant.CONDO_CLASS_NAME);
                Text txtStreetNo = new Text(80, 80, "Street No: "+((Condo) properties.get(i)).getStreetNo());
                hStreetNo = new HBox(txtStreetNo);

                Text txtUnitNo = new Text(80, 80, "Unit No: "+((Condo) properties.get(i)).getUnitNo());
                hUnitNo = new HBox(txtUnitNo);
            } 
            else if(Constant.HOUSE_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                lblHeader.setText(i+1 + ". " + Constant.HOUSE_CLASS_NAME);
                Text txtStreetNo = new Text(80, 80, "Street No: "+((House) properties.get(i)).getStreetNo());
                hStreetNo = new HBox(txtStreetNo);
            }
            hHeader = new HBox(lblHeader);

            Text txtNoBedRoom = new Text(80, 80, "Number of bed room: "+((Property) properties.get(i)).getNumberOfBedRoom());
            hBedRoom = new HBox(txtNoBedRoom);

            Text txtNoBathRoom = new Text(80, 80, "Number of bath room: "+((Property) properties.get(i)).getNumberOfBathRoom());
            hBathRoom = new HBox(txtNoBathRoom);

            Text txtFootage = new Text(80, 80, "Square Footage: "+((Property) properties.get(i)).getSquareFootage());
            hFootage = new HBox(txtFootage);

            Text txtStreetName = new Text(80, 80, "Street Name: "+((Property) properties.get(i)).getStreetName());
            hStreet = new HBox(txtStreetName);

            Text txtCity = new Text(80, 80, "City: "+((Property) properties.get(i)).getCity());
            hCity = new HBox(txtCity);

            Text txtPostalCode = new Text(80, 80, "Postal Code: "+((Property) properties.get(i)).getPostalCode());
            hPostalCode = new HBox(txtPostalCode);

            if(Constant.APARTMENT_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                vBoxProperty = new VBox(hHeader, hID, hCivicAddress, hAptNo, hBedRoom, hBathRoom,
                        hFootage, hStreet, hCity, hPostalCode);
            } else if(Constant.CONDO_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                vBoxProperty = new VBox(hHeader, hID, hStreetNo, hUnitNo, hBedRoom, hBathRoom,
                        hFootage, hStreet, hCity, hPostalCode);
            } else if(Constant.HOUSE_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                vBoxProperty = new VBox(hHeader, hID, hStreetNo, hBedRoom, hBathRoom,
                        hFootage, hStreet, hCity, hPostalCode);
            }
            vBoxProperty.setSpacing(5);
            vBoxProperty.setPadding(new Insets(10));
            vBoxProperty.setAlignment(Pos.CENTER);
            vBoxArray.add(vBoxProperty);
        }

        fpanes.getChildren().addAll(vBoxArray);
        // main menu button
        Pane pMenu = new Pane();
//        hTotal.setPadding(new Insets(20,20,20,20));
        hTotal.setLayoutX(50);
        hTotal.setLayoutY(50);
        hRefresh.setLayoutX(50);
        hRefresh.setLayoutY(100);
       
        pMenu.getChildren().addAll(hTotal, hRefresh);

        if(target == 1) {
            ScrollPane scrollPane = new ScrollPane(pMenu);
            BorderPane borderPropertyPane = new BorderPane(scrollPane);
            borderPropertyPane.setTop(fpanes);
            Scene propertyScene = new Scene(borderPropertyPane, 500, 550);

            secondStage.setTitle("All properties");
            secondStage.setScene(propertyScene);
            secondStage.show();
        }
        else {
            return vBoxArray;
        }
        return null;
    }

    @Override
    public void start(Stage primaryStage) {
        ArrayList<Tenant> tenants = propertyController.getTenantModel().getTenantList();
        HBox tenantsVBox = new HBox();
        tenantsVBox.setSpacing(10);
        int i = 0;
        if(tenants != null && tenants.size() > 0) {
            for(Tenant tenant:tenants) {
                i++;
                Label lblTenantNumber = new Label("Tenant " + i + ":");
                lblTenantNumber.setFont(new Font(20));
                Label lblTenantID = new Label("ID: " + tenant.getTenantId());
                Label lblTenantName = new Label("Name: " + tenant.getTenantName());
                Label lblTenantPhone = new Label("Phone: " + tenant.getTenantPhone());
                Label lblTenantEmail = new Label("Email: " + tenant.getTenantEmail());

                VBox tenantInfoHBox = new VBox(lblTenantNumber, lblTenantID, lblTenantName, lblTenantPhone, lblTenantEmail);
                tenantInfoHBox.setSpacing(5);
                tenantInfoHBox.setPadding(new Insets(10));

                ArrayList<Property> properties = tenant.getInterestedUnits();

                if(properties.size() > 0) {
                    int j = 0;
                    HBox unitsHBox = new HBox();
                    for (Property property:properties) {
                        j++;
                        Label lblPropertyNo = new Label("Property " + j + ":");
                        lblPropertyNo.setFont(new Font(20));
                        Label lblPropertyID = new Label("ID: " + property.getID());
                        VBox interestedUnitVBox = new VBox(lblPropertyNo,lblPropertyID);
                        interestedUnitVBox.setSpacing(5);
                        interestedUnitVBox.setPadding(new Insets(10));
                        unitsHBox.getChildren().add(interestedUnitVBox);
//                        tenantsVBox.getChildren().addAll(tenantInfoHBox, interestedUnitVBox);
                    }
                    tenantsVBox.getChildren().addAll(tenantInfoHBox, unitsHBox);
                }
            }
        }
        ScrollPane scrollPane = new ScrollPane(tenantsVBox);

        // main menu button
        Button btnMainMenu = new Button("Main Menu");
        HBox hMainMenu = new HBox(btnMainMenu);
        btnMainMenu.setOnAction(event -> {
            // go back to previous scene
            primaryStage.setScene(tenantController.getPreScene());
        });
        Pane pMenu = new Pane();
        hMainMenu.setPadding(new Insets(20));
        pMenu.getChildren().add(hMainMenu);

        // Build scene
        BorderPane borderPropertyPane = new BorderPane();
        borderPropertyPane.setTop(scrollPane);
        borderPropertyPane.setBottom(pMenu);
        Scene tenantScene = new Scene(borderPropertyPane, 550, 550);
        primaryStage.setTitle("Potential Tenants - Interested Unit"); // Set title
        primaryStage.setScene(tenantScene);
//        ArrayList<Property> properties = propertyController.getProperties();
//        Stage secondStage = new Stage();
//        if(properties.size() > 0) {
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Button btnRefresh = new Button("Refresh list");
//                    btnRefresh.setOnAction(actionEvent -> {
//                        buildScene(properties,1, btnRefresh, secondStage);
//                    });
//                    try {
//                        Platform.runLater(new Runnable() {
//                            @Override
//                            public void run() {
//                                buildScene(properties, 1, btnRefresh, secondStage);
//                            }
//                        });
//                    }
//                    catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                }
//            });
//            thread.start();
//        }
    }
}
