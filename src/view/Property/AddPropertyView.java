package view.Property;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.AppBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddPropertyView extends Application implements AppBase {
    @Override
    public void start(Stage primaryStage) {
        Map<String, ArrayList<Object>> result = new HashMap<>();
        ArrayList<Object> propertyData = new ArrayList<Object>();

        Button btnMainMenu = new Button("Main Menu");
        HBox hMainMenu = new HBox(btnMainMenu);
        Label statusMessage = new Label();
        HBox hStatus = new HBox(statusMessage);

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
        VBox vBoxProperty = null;
        TextField tfCivicAddress;
        TextField tfAptNo;
        TextField tfStreetNo;
        TextField tfUnitNo;
        if("A".equals(primaryStage.getUserData())) {
            primaryStage.setTitle("Add an apartment"); // Set title
            Text txtCivicAddress = new Text(80, 80, "Civic address: *");
            tfCivicAddress = new TextField();
            HBox hCivicAddress = new HBox(txtCivicAddress, tfCivicAddress);

            Text txtAptNo = new Text(80, 80, "Apt No: *");
            tfAptNo = new TextField();
            HBox hAptNo = new HBox(txtAptNo, tfAptNo);
            vBoxProperty = new VBox(hMainMenu, hStatus, hCivicAddress, hAptNo, hBedRoom, hBathRoom,
                    hFootage, hStreet, hCity, hPostalCode, btnSubmit);
            tfStreetNo = null;
            tfUnitNo = null;
        } else if ("C".equals(primaryStage.getUserData())) {
            primaryStage.setTitle("Add a condo"); // Set title
            Text txtStreetNo = new Text(80, 80, "Street No: *");
            tfStreetNo = new TextField();
            HBox hStreetNo = new HBox(txtStreetNo, tfStreetNo);

            Text txtUnitNo = new Text(80, 80, "Unit No: *");
            tfUnitNo = new TextField();
            HBox hUnitNo = new HBox(txtUnitNo, tfUnitNo);
            vBoxProperty = new VBox(hMainMenu, hStatus, hStreetNo, hUnitNo, hBedRoom, hBathRoom,
                    hFootage, hStreet, hCity, hPostalCode, btnSubmit);
            tfCivicAddress = null;
            tfAptNo = null;
        } else if ("H".equals(primaryStage.getUserData())) {
            primaryStage.setTitle("Add a house"); // Set title
            Text txtStreetNo = new Text(80, 80, "Street No: *");
            tfStreetNo = new TextField();
            HBox hStreetNo = new HBox(txtStreetNo, tfStreetNo);

            vBoxProperty = new VBox(hMainMenu, hStatus, hStreetNo, hBedRoom, hBathRoom,
                    hFootage, hStreet, hCity, hPostalCode, btnSubmit);
            tfUnitNo = null;
            tfCivicAddress = null;
            tfAptNo = null;
        } else {
            tfCivicAddress = null;
            tfAptNo = null;
            tfStreetNo = null;
            tfUnitNo = null;
        }

        vBoxProperty.setSpacing(25);
        vBoxProperty.setPadding(new Insets(95, 12, 15, 12));
        vBoxProperty.setAlignment(Pos.CENTER);
        Pane addPropertyPane = new Pane();
        // Hold buttons in an HBox
        BorderPane borderPropertyPane = new BorderPane(addPropertyPane);
        borderPropertyPane.setTop(vBoxProperty);
        Scene propertyScene = new Scene(borderPropertyPane, 650, 850);
        primaryStage.setScene(propertyScene);

        btnMainMenu.setOnAction(event -> {
            primaryStage.setTitle("Project Phase 2 Demo");
            primaryStage.setScene(propertyController.getPreScene());
        });

        btnSubmit.setOnAction(event -> {
            propertyData.add(Integer.parseInt(tfNoBedRoom.getText()));
            propertyData.add(Integer.parseInt(tfNoBathRoom.getText()));
            propertyData.add(Float.parseFloat(tfFootage.getText()));
            propertyData.add(tfStreetName.getText());
            propertyData.add(tfCity.getText());
            propertyData.add(tfPostalCode.getText());
            if("A".equals(primaryStage.getUserData())) {
                propertyData.add(tfCivicAddress.getText());
                propertyData.add(Integer.parseInt(tfAptNo.getText()));
                result.put("A", propertyData);
            } else if("C".equals(primaryStage.getUserData())) {
                propertyData.add(Integer.parseInt(tfStreetNo.getText()));
                propertyData.add(Integer.parseInt(tfUnitNo.getText()));
                result.put("C", propertyData);
            } else if("H".equals(primaryStage.getUserData())) {
                propertyData.add(Integer.parseInt(tfStreetNo.getText()));
                result.put("H", propertyData);
            }

            boolean returnResult = propertyController.addNewProperty(result);
            if(returnResult) {
                statusMessage.setText("Added new property successfully!");
                statusMessage.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
            }
        });
    }
}
