package view.Property;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Lease;
import model.Property;
import model.Tenant;
import view.AppBase;
import view.Tenant.DisplayTenantView;

import java.util.ArrayList;

public class InterestInUnitView extends Application implements AppBase {
    VBox tenantBox;
    ArrayList<VBox> propertyBox;
    @Override
    public void start(Stage primaryStage) {
        ArrayList<Object> info = new ArrayList<>();

        Button btnMainMenu = new Button("Main Menu");
        HBox hMainMenu = new HBox(btnMainMenu);

        Label statusMessage = new Label();
        HBox hStatus = new HBox(statusMessage);

        //showing properties
        ArrayList<Property> properties = propertyController.getProperties();
        if(properties.size() > 0) {
            DisplayPropertyView displayPropertyView = new DisplayPropertyView();
            Button btnRefresh = new Button();
            propertyBox = displayPropertyView.buildScene(properties, 0, btnRefresh, null);
        }

        //showing tenants
        ArrayList<Tenant> tenants = tenantController.getTenants();
        if(tenants.size() > 0) {
            DisplayTenantView displayTenantView = new DisplayTenantView();
            tenantBox = displayTenantView.displayTenants(primaryStage, tenants, 0);
        }

        Text txtAppartmentID = new Text(80, 80, "Enter Property ID you are interested in: ");
        TextField tfAppartmentID = new TextField();
        HBox hAppartmentID = new HBox(txtAppartmentID, tfAppartmentID);

        Text txtTenantID = new Text(80, 80, "Enter Tenant ID: ");
        TextField tfTenantID = new TextField();
        HBox hTenantID = new HBox(txtTenantID, tfTenantID);

        Button btnSubmit = new Button("Submit");

        if(tenantBox != null) {
            VBox vBoxProperty = new VBox(hMainMenu, new Separator(), tenantBox, new Separator(), hStatus, hAppartmentID, hTenantID, btnSubmit);
            vBoxProperty.getChildren().addAll(1, propertyBox);
            vBoxProperty.setSpacing(25);
            vBoxProperty.setPadding(new Insets(95, 12, 15, 12));
            vBoxProperty.setAlignment(Pos.CENTER);

            Pane addRentalPane = new Pane();
            BorderPane borderPropertyPane = new BorderPane(addRentalPane);
            borderPropertyPane.setTop(vBoxProperty);

            Scene rentScene = new Scene(borderPropertyPane, 500, 550);
            primaryStage.setTitle("Express an interest in a unit");
            primaryStage.setScene(rentScene);

            ScrollPane scrollPane = new ScrollPane(vBoxProperty);
            scrollPane.setMaxWidth(Double.MAX_VALUE);
            scrollPane.setMaxHeight(Double.MAX_VALUE);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
            borderPropertyPane.setCenter(scrollPane);

            btnMainMenu.setOnAction(event -> {
                primaryStage.setTitle("Project Phase 2 Demo");
                primaryStage.setScene(propertyController.getPreScene());
            });

            btnSubmit.setOnAction(event -> {
                if(!tfAppartmentID.getText().isEmpty() && !tfTenantID.getText().isEmpty()) {
                    String interestedData = tfTenantID.getText() + "-" + tfAppartmentID.getText();
                    boolean returnResult = propertyController.interestedInAUnit(interestedData, tenants);
                    if(returnResult) {
                        statusMessage.setText("Added interested unit successfully!");
                        statusMessage.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
                    }
                }
            });
        } else {
            System.out.println("The list of tenants is empty!");
        }
    }
}
