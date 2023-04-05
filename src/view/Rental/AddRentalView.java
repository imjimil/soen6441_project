package view.Rental;

import java.util.ArrayList;

import controller.TenantController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import model.Lease;
import model.Tenant;
import view.AppBase;
import view.TenantView;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.text.Font;


public class AddRentalView extends Application implements AppBase {

    private TextField tfStartDay, tfStartMonth, tfStartYear, tfEndDay, tfEndMonth, tfEndYear;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Lease lease = new Lease();
        ArrayList<Object> info = new ArrayList<>();

        Button btnMainMenu = new Button("Main Menu");
        HBox hMainMenu = new HBox(btnMainMenu);
        Label statusMessage = new Label();
        HBox hStatus = new HBox(statusMessage);

        //tenant box
        VBox tenantBox = new VBox();
        tenantBox.setSpacing(10);
        tenantBox.setPadding(new Insets(10));
        tenantBox.setAlignment(Pos.CENTER_LEFT);


        //showing tenants
        TenantController tenantController = new TenantController();
        ArrayList<Tenant> tenants = tenantController.getTenants();
        Label lblTenantCount = new Label("Total Tenants: " + tenants.size());
        for (int i = 0; i < tenants.size(); i++) {
            Tenant tenant = tenants.get(i);
            String tenantInfo = (i + 1) + ". " + tenant.getID() + " | " + tenant.getTenantName() + " | " + tenant.getTenantEmail() + " | " + tenant.getTenantPhone();
            Label tenantLabel = new Label(tenantInfo);
            tenantLabel.setFont(Font.font("Verdana", 12));
            tenantBox.getChildren().add(tenantLabel);
        }


        Text txtAppartmentID = new Text(80, 80, "Appartment ID you want to lease: ");
        TextField tfAppartmentID = new TextField();
        HBox hAppartmentID = new HBox(txtAppartmentID, tfAppartmentID);

        Text txtTenantID = new Text(80, 80, "Tenant ID: ");
        TextField tfTenantID = new TextField();
        HBox hTenantID = new HBox(txtTenantID, tfTenantID);

        Text txtStartDate = new Text(80, 80, "Lease Start Date (dd/mm/yyyy): ");
        tfStartDay = new TextField();
        tfStartDay.setPromptText("Day");
        tfStartMonth = new TextField();
        tfStartMonth.setPromptText("Month");
        tfStartYear = new TextField();
        tfStartYear.setPromptText("Year");
        HBox hStartDate = new HBox(txtStartDate, tfStartDay, tfStartMonth, tfStartYear);

        Text txtEndDate = new Text(80, 80, "Lease End Date (dd/mm/yyyy): ");
        tfEndDay = new TextField();
        tfEndDay.setPromptText("Day");
        tfEndMonth = new TextField();
        tfEndMonth.setPromptText("Month");
        tfEndYear = new TextField();
        tfEndYear.setPromptText("Year");
        HBox hEndDate = new HBox(txtEndDate, tfEndDay, tfEndMonth, tfEndYear);

        Text txtTotalRent = new Text(80, 80, "Total Rent: ");
        TextField tfTotalRent = new TextField();
        HBox hTotalRent = new HBox(txtTotalRent, tfTotalRent);

        Text txtRentPaid = new Text(80, 80, "Rent Paid: ");
        CheckBox cbRentPaid = new CheckBox();
        HBox hRentPaid = new HBox(txtRentPaid, cbRentPaid);

        Button btnSubmit = new Button("Submit");
        VBox vBoxProperty = new VBox(hMainMenu,lblTenantCount, tenantBox, hStatus, hAppartmentID, hTenantID, hStartDate, hEndDate, hTotalRent, hRentPaid, btnSubmit);

        vBoxProperty.setSpacing(25);
        vBoxProperty.setPadding(new Insets(95, 12, 15, 12));
        vBoxProperty.setAlignment(Pos.CENTER);

        Pane addRentalPane = new Pane();
        BorderPane borderPropertyPane = new BorderPane(addRentalPane);
        borderPropertyPane.setTop(vBoxProperty);  

        Scene rentScene = new Scene(borderPropertyPane, 500, 550);
        primaryStage.setTitle("Rent an Appartment:");
        primaryStage.setScene(rentScene);

        ScrollPane scrollPane = new ScrollPane(vBoxProperty);
        scrollPane.setMaxWidth(Double.MAX_VALUE);
        scrollPane.setMaxHeight(Double.MAX_VALUE);
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        borderPropertyPane.setCenter(scrollPane);

        btnMainMenu.setOnAction(event -> {
            primaryStage.setTitle("Project Phase 2 Demo");
            primaryStage.setScene(rentalController.getPreScene());
        });

        btnSubmit.setOnAction(event -> {
            
        });
    }
    
}
