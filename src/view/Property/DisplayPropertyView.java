package view.Property;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Apartment;
import model.Condo;
import model.House;
import model.Property;
import utility.Constant;
import view.AppBase;

import java.util.ArrayList;

public class DisplayPropertyView extends Application implements AppBase {
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
        ArrayList<Property> properties = propertyController.getProperties();
        Stage secondStage = new Stage();
        if(properties.size() > 0) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Button btnRefresh = new Button("Refresh list");

                    btnRefresh.setOnAction(actionEvent -> {
                        buildScene(properties,1, btnRefresh, secondStage);
                    });
                    try {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                buildScene(properties, 1, btnRefresh, secondStage);
                            }    
                        });
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }
}
