package view.Property;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Property> properties = propertyController.getProperties();
        if(properties.size() > 0) {
            Stage secondStage = new Stage();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Button btnRefresh = new Button("Refresh list");

                                buildScene(btnRefresh);
                                btnRefresh.setOnAction(actionEvent -> {
                                    buildScene(btnRefresh);
                                });
                            }

                            private void buildScene(Button btnRefresh) {
                                HBox hTotal;
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

                                HBox hRefresh = new HBox(btnRefresh);
                                HBox hHeader;
                                FlowPane fpanes = new FlowPane();
                                VBox vBoxProperty = null;
                                ArrayList<VBox> vBoxArray = new ArrayList<>();
                                for (int i = 0; i < properties.size(); i++) {
                                    lblHeader = new Label();
                                    if(Constant.APARTMENT_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                                        lblHeader.setText(i+1 + ". " + Constant.APARTMENT_CLASS_NAME);
                                        Text txtCivicAddress = new Text(180, 180, "Civic address: " + ((Apartment) properties.get(i)).getCivicAddress());
                                        txtCivicAddress.setStyle("-fx-text-fill: red;");
                                        hCivicAddress = new HBox(txtCivicAddress);
                                        hCivicAddress.setSpacing(10);

                                        Text txtAptNo = new Text(80, 80, "Apt No: "+((Apartment) properties.get(i)).getAptNo());
                                        txtAptNo.setStyle("-fx-text-fill: red;");
                                        hAptNo = new HBox(txtAptNo);
                                        hAptNo.setSpacing(10);
                                    } else if(Constant.CONDO_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                                        lblHeader.setText(i+1 + ". " + Constant.CONDO_CLASS_NAME);
                                        Text txtStreetNo = new Text(80, 80, "Street No: "+((Condo) properties.get(i)).getStreetNo());
                                        txtStreetNo.setStyle("-fx-text-fill: red;");
                                        hStreetNo = new HBox(txtStreetNo);
                                        hStreetNo.setSpacing(10);

                                        Text txtUnitNo = new Text(80, 80, "Unit No: "+((Condo) properties.get(i)).getUnitNo());
                                        txtUnitNo.setStyle("-fx-text-fill: red;");
                                        hUnitNo = new HBox(txtUnitNo);
                                        hUnitNo.setSpacing(10);
                                    } else if(Constant.HOUSE_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                                        lblHeader.setText(i+1 + ". " + Constant.HOUSE_CLASS_NAME);
                                        Text txtStreetNo = new Text(80, 80, "Street No: "+((House) properties.get(i)).getStreetNo());
                                        txtStreetNo.setStyle("-fx-text-fill: red;");
                                        hStreetNo = new HBox(txtStreetNo);
                                        hStreetNo.setSpacing(10);
                                    }
                                    hHeader = new HBox(lblHeader);
                                    hHeader.setSpacing(10);

                                    Text txtNoBedRoom = new Text(80, 80, "Number of bed room: "+((Property) properties.get(i)).getNumberOfBedRoom());
                                    hBedRoom = new HBox(txtNoBedRoom);
                                    hBedRoom.setSpacing(10);

                                    Text txtNoBathRoom = new Text(80, 80, "Number of bath room: "+((Property) properties.get(i)).getNumberOfBathRoom());
                                    hBathRoom = new HBox(txtNoBathRoom);
                                    hBathRoom.setSpacing(10);

                                    Text txtFootage = new Text(80, 80, "Square Footage: "+((Property) properties.get(i)).getSquareFootage());
                                    hFootage = new HBox(txtFootage);
                                    hFootage.setSpacing(10);

                                    Text txtStreetName = new Text(80, 80, "Street Name: "+((Property) properties.get(i)).getStreetName());
                                    hStreet = new HBox(txtStreetName);
                                    hStreet.setSpacing(10);

                                    Text txtCity = new Text(80, 80, "City: "+((Property) properties.get(i)).getCity());
                                    hCity = new HBox(txtCity);
                                    hCity.setSpacing(10);

                                    Text txtPostalCode = new Text(80, 80, "Postal Code: "+((Property) properties.get(i)).getPostalCode());
                                    hPostalCode = new HBox(txtPostalCode);
                                    hPostalCode.setSpacing(10);

                                    if(Constant.APARTMENT_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                                        vBoxProperty = new VBox(hHeader, hCivicAddress, hAptNo, hBedRoom, hBathRoom,
                                                hFootage, hStreet, hCity, hPostalCode);
                                    } else if(Constant.CONDO_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                                        vBoxProperty = new VBox(hHeader, hStreetNo, hUnitNo, hBedRoom, hBathRoom,
                                                hFootage, hStreet, hCity, hPostalCode);
                                    } else if(Constant.HOUSE_CLASS_NAME.equals(properties.get(i).getClass().getSimpleName())) {
                                        vBoxProperty = new VBox(hHeader, hStreetNo, hBedRoom, hBathRoom,
                                                hFootage, hStreet, hCity, hPostalCode);
                                    }
                                    vBoxProperty.setSpacing(25);
                                    vBoxProperty.setPadding(new Insets(35, 12, 15, 20));
                                    vBoxProperty.setAlignment(Pos.CENTER);
                                    vBoxArray.add(vBoxProperty);
                                }
                                fpanes.getChildren().addAll(vBoxArray);
                                // main menu button
                                Pane pMenu = new Pane();
                                hTotal.setPadding(new Insets(20,20,20,20));
                                hTotal.setLayoutX(50);
                                hTotal.setLayoutY(50);
                                hRefresh.setLayoutX(50);
                                hRefresh.setLayoutY(100);
                                pMenu.getChildren().addAll(hTotal, hRefresh);
                                // Build scene
                                BorderPane borderPropertyPane = new BorderPane(pMenu);
                                borderPropertyPane.setTop(fpanes);
                                Scene propertyScene = new Scene(borderPropertyPane, 650, 850);

                                secondStage.setTitle("All properties");
                                secondStage.setScene(propertyScene);
                                secondStage.show();
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
